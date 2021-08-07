package edu.miu.cs.cs544.flightreservation.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reservationCode;

    @ManyToOne
    private Person passenger;

    @OneToMany
    private List<Flight> itinerary;
    private LocalDateTime reservationDateTime;

    @ManyToOne
    private Person reservedBy;

    @ManyToOne
    private Status status;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.PERSIST)
    private List<Ticket> ticket;
}
