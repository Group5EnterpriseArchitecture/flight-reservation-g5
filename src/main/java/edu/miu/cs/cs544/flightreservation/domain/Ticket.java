package edu.miu.cs.cs544.flightreservation.domain;

import java.time.LocalDate;

public class Ticket {
    private Long id;
    private Long ticketNumber;
    private Reservation reservation;
    private LocalDate flightDate;
    private Flight flight;
}
