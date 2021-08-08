package edu.miu.cs.cs544.flightreservation.DTO;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
public class TicketDTO {
    private Long id;
    private Long ticketNumber;
    private ReservationDTO reservationDTO;
    private LocalDate flightDate;
    private FlightDTO flight;
}
