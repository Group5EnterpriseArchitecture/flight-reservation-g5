package edu.miu.cs.cs544.flightreservation.DTO.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {

    @NotNull
    @Pattern(regexp = "[a-zA-Z]{1,5}[0-9]{3}")
    private String flightNumber;
    @NotNull
    private Integer capacity;
    @NotNull
    private String departureAirportCode;
    @NotNull
    private String arrivalAirportCode;
    @NotNull
    @FutureOrPresent
    private LocalDateTime departureTime;
    @NotNull
    @FutureOrPresent
    private LocalDateTime arrivalTime;
    private String operateBy;


}
