package edu.miu.cs.cs544.flightreservation.domain;


public enum EStatus {
    PAID("PAID"),
    PENDING("PENDING"),
    CANCELLED("CANCELLED"),
    EXPIRED("EXPIRED");
    private final String name;
    EStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
