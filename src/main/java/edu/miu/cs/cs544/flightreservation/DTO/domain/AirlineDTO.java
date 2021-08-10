package edu.miu.cs.cs544.flightreservation.DTO.domain;

import lombok.Data;

@Data
public class AirlineDTO {

    private String code;
    private String name;
    private String history;

    public AirlineDTO(String code, String name, String history) {
        this.code = code;
        this.name = name;
        this.history = history;
    }
}
