package edu.miu.cs.cs544.flightreservation.DTO.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PersonDTO {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private AddressDTO residenceAddressDTO;

    public PersonDTO(String firstName, String lastName, LocalDate birthDate, String email, AddressDTO residenceAddressDTO) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.residenceAddressDTO = residenceAddressDTO;
    }
}
