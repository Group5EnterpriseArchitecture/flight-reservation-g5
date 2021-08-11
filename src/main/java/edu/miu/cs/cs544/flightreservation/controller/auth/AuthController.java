package edu.miu.cs.cs544.flightreservation.controller.auth;

import edu.miu.cs.cs544.flightreservation.DTO.security.request.LoginRequestDTO;
import edu.miu.cs.cs544.flightreservation.DTO.security.request.SignupRequestDTO;
import edu.miu.cs.cs544.flightreservation.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestDTO request) {
        return new ResponseEntity<>(authenticationService.authenticateUser(request), HttpStatus.OK);
    }

    @PostMapping("/register")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequestDTO request) {
        return new ResponseEntity<>(authenticationService.registerUser(request), HttpStatus.OK);
    }

    // TODO: Sign up controller
}
