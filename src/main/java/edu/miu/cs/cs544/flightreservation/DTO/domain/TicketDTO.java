package edu.miu.cs.cs544.flightreservation.DTO.domain;

import edu.miu.cs.cs544.flightreservation.domain.Ticket;
import edu.miu.cs.cs544.flightreservation.service.Adapter.FlightAdapter;
import lombok.Data;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
public class TicketDTO {
    @Pattern(regexp = "[0-9]{20}")
    private String ticketNumber;
    @FutureOrPresent
    private LocalDateTime flightDate;
    private FlightDTO flight;

    public TicketDTO(Ticket ticket) {
        this.ticketNumber = ticket.getTicketNumber();
        this.flightDate = ticket.getFlightDate();
        this.flight = FlightAdapter.getFlightDTOFromFlight(ticket.getFlight());
    }
}
