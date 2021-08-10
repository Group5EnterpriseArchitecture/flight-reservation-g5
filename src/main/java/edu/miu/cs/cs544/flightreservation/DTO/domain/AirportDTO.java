package edu.miu.cs.cs544.flightreservation.DTO.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class AirportDTO {

    private String code;
    private String name;
    private AddressDTO addressDTO;

    public AirportDTO(String code, String name, AddressDTO addressDTO) {
        this.code = code;
        this.name = name;
        this.addressDTO = addressDTO;
    }
}
