package edu.miu.cs.cs544.flightreservation.domain;

import java.time.LocalTime;

public class Flight {
    private Long id;
    private String flightNumber;
    private Integer capacity;
    private Airport departure;
    private Airport arrival;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private Airline operateBy;

}
