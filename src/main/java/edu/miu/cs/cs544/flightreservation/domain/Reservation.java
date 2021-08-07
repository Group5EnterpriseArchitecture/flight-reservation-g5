package edu.miu.cs.cs544.flightreservation.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Reservation {
    private Long id;
    private String reservationCode;
    private Person passenger;
    private List<Flight> itinerary;
    private LocalDateTime reservationDateTime;
    private Person reserveBy;
    private Status status;
}
