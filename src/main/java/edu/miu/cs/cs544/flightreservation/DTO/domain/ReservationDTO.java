package edu.miu.cs.cs544.flightreservation.DTO.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
public class ReservationDTO {
    @Pattern(regexp = "[a-zA-Z0-9]{6}")
    private String reservationCode;
    private PersonDTO passenger;
    private List<String> itinerary;
    private List<FlightDTO> itineraryOfFlights;
    @FutureOrPresent
    private LocalDateTime reservationDateTime;

    public ReservationDTO(String reservationCode,
                          PersonDTO passenger,
                          List<String> itinerary,
                          List<FlightDTO> itineraryOfFlights,
                          LocalDateTime reservationDateTime) {
        this.reservationCode = reservationCode;
        this.passenger = passenger;
        this.itinerary = itinerary;
        this.itineraryOfFlights = itineraryOfFlights;
        this.reservationDateTime = reservationDateTime;
    }
}
