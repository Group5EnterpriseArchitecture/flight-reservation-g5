package edu.miu.cs.cs544.flightreservation.security.service;

import edu.miu.cs.cs544.flightreservation.domain.UserCredentials;
import edu.miu.cs.cs544.flightreservation.repository.UserCredentialsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static edu.miu.cs.cs544.flightreservation.security.service.EUserRole.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserCredentialsRepository userCredentialsRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserCredentials user = userCredentialsRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("UserCredentials Not Found with username: " + username));

        String role = user.getRoleAsString();

        // Get authorities belonging to a particular ROLE
        Set<SimpleGrantedAuthority> authorities;

        switch (role) {
            case "ROLE_ADMIN":
                authorities = ADMIN.getGrantedAuthorities();
                break;
            case "ROLE_AGENT":
                authorities = AGENT.getGrantedAuthorities();
                break;
            case "ROLE_PASSENGER":
                authorities = PASSENGER.getGrantedAuthorities();
                break;
            default:
                throw new IllegalStateException("Unexpected ROLE: " + role);
        }

        return new UserDetailsImpl(
                user.getUsername(),
                user.getPassword(),
                user.getPerson().getEmail(),
                authorities,
                true,
                true,
                true,
                true);
    }
}
