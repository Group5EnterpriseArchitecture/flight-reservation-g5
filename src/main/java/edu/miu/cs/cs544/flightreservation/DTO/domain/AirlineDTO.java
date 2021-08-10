package edu.miu.cs.cs544.flightreservation.DTO.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AirlineDTO {

    @NotNull
    @Size(min = 2, max = 3)
    private String code;
    @Size(max = 100)
    private String name;
    @Size(max = 2000)
    private String history;

    public AirlineDTO(String code, String name, String history) {
        this.code = code;
        this.name = name;
        this.history = history;
    }
}
