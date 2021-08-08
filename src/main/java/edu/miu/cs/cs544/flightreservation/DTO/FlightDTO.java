package edu.miu.cs.cs544.flightreservation.DTO;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Data
public class FlightDTO {

    private Long id;
    private String flightNumber;
    private Integer capacity;

    private AirportDTO departure;

    private AirportDTO arrival;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private AirlineDTO operateBy;

}
