package edu.miu.cs.cs544.flightreservation.DTO.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {

    private String flightNumber;
    private Integer capacity;
    private String departureAirportCode;
    private String arrivalAirportCode;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String operateBy;


}
