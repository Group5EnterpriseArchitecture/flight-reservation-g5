package edu.miu.cs.cs544.flightreservation.security.service;

public enum EUserPermission {
    FLIGHT_READ("flight:read"),
    FLIGHT_WRITE("flight:write"),

    RESERVATION_WRITE("reservation:write"),
    RESERVATION_READ("reservation:read"),

    TICKET_READ("ticket:read"),
    TICKET_WRITE("ticket:write"),

    AIRLINE_READ("airline:read"),
    AIRLINE_WRITE("airline:write"),

    AIRPORT_READ("airport:read"),
    AIRPORT_WRITE("airport:write"),

    PERSON_READ("person:read"),
    PERSON_WRITE("person:write");

    private final String permission;

    EUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
