package edu.miu.cs.cs544.flightreservation.DTO.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PersonDTO {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Past
    private LocalDate birthDate;
    @Email
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
