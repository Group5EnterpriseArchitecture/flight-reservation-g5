package edu.miu.cs.cs544.flightreservation.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonDTO {


    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private AddressDTO residenceAddressDTO;
}
