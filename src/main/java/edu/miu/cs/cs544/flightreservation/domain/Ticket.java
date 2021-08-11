package edu.miu.cs.cs544.flightreservation.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String ticketNumber;
    @ManyToOne
    private Reservation reservation;
    private LocalDateTime flightDate;
    @ManyToOne
    private Flight flight;

    public Ticket(String ticketNumber, Reservation reservation, LocalDateTime flightDate, Flight flight) {
        this.ticketNumber = ticketNumber;
        this.reservation = reservation;
        this.flightDate = flightDate;
        this.flight = flight;
    }
}
