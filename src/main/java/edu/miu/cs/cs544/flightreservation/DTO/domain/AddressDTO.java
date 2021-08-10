package edu.miu.cs.cs544.flightreservation.DTO.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {

    private String street;
    private String city;
    private String state;
    private String zip;

    public AddressDTO(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}
