package edu.miu.cs.cs544.flightreservation.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class ReservationDTO {


    private Long id;
    private String reservationCode;

    private PersonDTO passenger;

    private List<FlightDTO> itinerary;
    private LocalDateTime reservationDateTime;
    private PersonDTO reservedBy;
    private StatusDTO statusDTO;
    private List<TicketDTO> ticketDTO;
}
