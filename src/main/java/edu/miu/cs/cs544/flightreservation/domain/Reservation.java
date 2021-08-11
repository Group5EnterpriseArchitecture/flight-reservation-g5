package edu.miu.cs.cs544.flightreservation.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 6)
    private String reservationCode;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Person passenger;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Flight> itinerary;
    private LocalDateTime reservationDateTime;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Person reservedBy;

    @Enumerated(EnumType.STRING)
    private EStatus status;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.PERSIST)
    private List<Ticket> tickets;

    public Reservation(String reservationCode,
                       Person passenger,
                       List<Flight> itinerary,
                       LocalDateTime reservationDateTime,
                       Person reservedBy,
                       EStatus status,
                       List<Ticket> tickets) {
        this.reservationCode = reservationCode;
        this.passenger = passenger;
        this.itinerary = itinerary;
        this.reservationDateTime = reservationDateTime;
        this.reservedBy = reservedBy;
        this.status = status;
        this.tickets = tickets;
    }
}
