package edu.miu.cs.cs544.flightreservation.service;

import edu.miu.cs.cs544.flightreservation.DTO.domain.FlightDTO;
import edu.miu.cs.cs544.flightreservation.domain.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {
    FlightDTO addFlight(FlightDTO flightDTO);
    List<FlightDTO> getFlights(String departure, String arrival, LocalDate departureTime);
    FlightDTO updateFlight(String flightNumber, Flight flight);
    void deleteFlight(String flightNumber);
    List<FlightDTO> getFlights();
}
