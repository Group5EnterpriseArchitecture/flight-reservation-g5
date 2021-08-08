package edu.miu.cs.cs544.flightreservation.DTO;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class TicketDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ticketNumber;
    @ManyToOne
    private ReservationDTO reservationDTO;
    private LocalDate flightDate;
    @ManyToOne
    private FlightDTO flight;
}
