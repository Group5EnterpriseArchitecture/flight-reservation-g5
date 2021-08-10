package edu.miu.cs.cs544.flightreservation.security.service;

import edu.miu.cs.cs544.flightreservation.domain.ERole;
import edu.miu.cs.cs544.flightreservation.domain.Person;
import edu.miu.cs.cs544.flightreservation.domain.Role;
import edu.miu.cs.cs544.flightreservation.domain.UserCredentials;
import edu.miu.cs.cs544.flightreservation.DTO.security.request.LoginRequestDTO;
import edu.miu.cs.cs544.flightreservation.DTO.security.request.SignupRequestDTO;
import edu.miu.cs.cs544.flightreservation.DTO.security.response.GenericResponseDTO;
import edu.miu.cs.cs544.flightreservation.DTO.security.response.LoginResponseDTO;
import edu.miu.cs.cs544.flightreservation.DTO.security.response.MessageResponseDTO;
import edu.miu.cs.cs544.flightreservation.exception.BadRequestException;
import edu.miu.cs.cs544.flightreservation.repository.PersonRepository;
import edu.miu.cs.cs544.flightreservation.repository.RoleRepository;
import edu.miu.cs.cs544.flightreservation.repository.UserCredentialsRepository;
import edu.miu.cs.cs544.flightreservation.security.jwt.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthenticationServiceImpl implements edu.miu.cs.cs544.flightreservation.security.service.AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final UserCredentialsRepository userCredentialsRepository;

    private final PersonRepository personRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtils jwtUtils;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, UserCredentialsRepository userCredentialsRepository, PersonRepository personRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userCredentialsRepository = userCredentialsRepository;
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public GenericResponseDTO authenticateUser(LoginRequestDTO request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> rolesAndAuthorities = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        String role = rolesAndAuthorities.stream().filter(s -> s.startsWith("ROLE_"))
                .findFirst().orElse("NO_ROLE");

        return new LoginResponseDTO(jwt,
                userDetails.getUsername(),
                userDetails.getEmail(),
                role).getResponse("OK");
    }

    @Override
    public GenericResponseDTO registerUser(SignupRequestDTO request) throws BadRequestException {
        if (userCredentialsRepository.existsByUsername(request.getUsername())) {
            throw new BadRequestException("Error: Username is already taken!");
        }

        if (personRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Error: Email is already in use!");
        }

        String stringRole = request.getRole();

        Role userRole;
        // Validate Role provided
        switch (stringRole) {
            case "admin":
                userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));

                break;
            case "agent":
                userRole = roleRepository.findByName(ERole.ROLE_AGENT)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));

                break;
            default:
                userRole = roleRepository.findByName(ERole.ROLE_PASSENGER)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        }

        // Create new account credentials
        UserCredentials userCredentials = new UserCredentials(request.getUsername(),
                passwordEncoder.encode(request.getPassword()), stringRole);

        // Create new Person
        Person person = new Person(request.getFirstName(),
                request.getLastName(), request.getEmail());

        userCredentials.setRole(userRole);
        userCredentials.setPerson(person);
        userCredentialsRepository.save(userCredentials);

        return new MessageResponseDTO("UserCredentials registered successfully!").getResponse("0K");
        // return ResponseEntity.ok(new GenericResponseDTO("created", person));
    }
}
