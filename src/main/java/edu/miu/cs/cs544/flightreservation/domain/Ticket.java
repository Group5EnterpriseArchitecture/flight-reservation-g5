package edu.miu.cs.cs544.flightreservation.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ticketNumber;
    @ManyToOne
    private Reservation reservation;
    private LocalDate flightDate;
    @ManyToOne
    private Flight flight;
}
