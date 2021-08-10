package edu.miu.cs.cs544.flightreservation.DTO.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
public class AirportDTO {

    @NotNull
    @Size(min = 3, max = 3)
    private String code;
    @NotNull
    @Size(min = 100)
    private String name;
    private AddressDTO addressDTO;

    public AirportDTO(String code, String name, AddressDTO addressDTO) {
        this.code = code;
        this.name = name;
        this.addressDTO = addressDTO;
    }
}
