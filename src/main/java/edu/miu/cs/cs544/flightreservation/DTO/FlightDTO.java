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

    public FlightDTO(String flightNumber, Integer capacity, AirportDTO departure, AirportDTO arrival, LocalTime departureTime, LocalTime arrivalTime, AirlineDTO operateBy) {
        this.flightNumber = flightNumber;
        this.capacity = capacity;
        this.departure = departure;
        this.arrival = arrival;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.operateBy = operateBy;
    }
}
