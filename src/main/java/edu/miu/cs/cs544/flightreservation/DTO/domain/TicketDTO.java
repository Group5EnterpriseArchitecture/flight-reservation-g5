package edu.miu.cs.cs544.flightreservation.DTO.domain;

import edu.miu.cs.cs544.flightreservation.domain.Ticket;
import edu.miu.cs.cs544.flightreservation.service.FlightAdapter;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketDTO {
    private String ticketNumber;
    private LocalDateTime flightDate;
    private FlightDTO flight;

    public TicketDTO(Ticket ticket) {
        this.ticketNumber = ticket.getTicketNumber();
        this.flightDate = ticket.getFlightDate();
        this.flight = FlightAdapter.getFlightDTOFromFlight(ticket.getFlight());
    }
}
