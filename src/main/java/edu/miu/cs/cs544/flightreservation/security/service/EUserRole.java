package edu.miu.cs.cs544.flightreservation.security.service;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static edu.miu.cs.cs544.flightreservation.security.service.EUserPermission.*;


public enum EUserRole {
    PASSENGER(Sets.newHashSet()),
    AGENT(Sets.newHashSet(RESERVATION_READ, RESERVATION_WRITE)),
    ADMIN(Sets.newHashSet(FLIGHT_READ, FLIGHT_WRITE, RESERVATION_WRITE,
            RESERVATION_READ, TICKET_READ, TICKET_WRITE,
            AIRLINE_READ, AIRLINE_WRITE, AIRPORT_READ,
            AIRPORT_WRITE, PERSON_READ, PERSON_WRITE));

    private final Set<EUserPermission> permissions;

    EUserRole(Set<EUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<EUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
