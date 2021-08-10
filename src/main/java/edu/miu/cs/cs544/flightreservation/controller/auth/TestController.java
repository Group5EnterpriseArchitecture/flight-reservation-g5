package edu.miu.cs.cs544.flightreservation.controller.auth;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/agent-admin")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT')")
    public String agentAdminAccess() {
        return "AGENT ADMIN ACCESS.";
    }

    @GetMapping("/agent")
    @PreAuthorize("hasRole('AGENT')")
    public String agentAccess() {
        return "Agent ONLY Access.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin ONLY.";
    }

    @GetMapping("/register")
    @PreAuthorize("hasAuthority('person:write')")
    public String addUser() {
        return "ROLES THAT HAVE AUTHORITY TO ADD PERSON";
    }

    @GetMapping("/me")
    @PreAuthorize("hasAnyRole('ADMIN', 'PASSENGER', 'AGENT')")
    public String currentUserName(Authentication authentication) {
        // username
        return authentication.getName();
    }

}
