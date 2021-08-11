package edu.miu.cs.cs544.flightreservation.service;

import edu.miu.cs.cs544.flightreservation.DTO.domain.FlightDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {
    FlightDTO addFlight(FlightDTO flightDTO);
    List<FlightDTO> getFlights(String departure, String arrival, LocalDate departureTime);
    FlightDTO updateFlight(String flightNumber, FlightDTO flightDTO);
    void deleteFlight(String flightNumber);
    List<FlightDTO> getFlights();
    Page<FlightDTO> getAllFlights(Pageable pageable);
}
