package edu.miu.cs.cs544.flightreservation.domain;

import java.time.LocalDate;

public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private Address residenceAddress;
}
