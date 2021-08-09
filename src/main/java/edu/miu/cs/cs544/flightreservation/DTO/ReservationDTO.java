package edu.miu.cs.cs544.flightreservation.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    private String reservationCode;
    private PersonDTO passenger;
    private List<FlightDTO> itinerary;
    private LocalDateTime reservationDateTime;
}
