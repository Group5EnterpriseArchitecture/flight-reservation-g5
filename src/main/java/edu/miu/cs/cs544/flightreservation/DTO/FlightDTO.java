package edu.miu.cs.cs544.flightreservation.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightDTO {

    private String flightNumber;
    private Integer capacity;
    private AirportDTO departure;
    private AirportDTO arrival;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private AirlineDTO operateBy;

    public FlightDTO(String flightNumber, Integer capacity, AirportDTO departure, AirportDTO arrival, LocalDateTime departureTime, LocalDateTime arrivalTime, AirlineDTO operateBy) {
        this.flightNumber = flightNumber;
        this.capacity = capacity;
        this.departure = departure;
        this.arrival = arrival;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.operateBy = operateBy;
    }
}
