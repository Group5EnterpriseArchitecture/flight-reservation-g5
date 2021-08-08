package edu.miu.cs.cs544.flightreservation.DTO;

import lombok.Data;

@Data
public class AirlineDTO {

    private Long id;
    private String code;
    private String name;
    private String history;

}
