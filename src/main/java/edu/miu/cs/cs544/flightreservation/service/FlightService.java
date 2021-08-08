package edu.miu.cs.cs544.flightreservation.service;

import edu.miu.cs.cs544.flightreservation.DTO.FlightDTO;
import edu.miu.cs.cs544.flightreservation.domain.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    FlightDTO addFlight(Flight flight);
    List<FlightDTO> getFlights(String departure, String arrival, LocalDateTime departureTime);
    FlightDTO updateFlight(String flightNumber, Flight flight);
    FlightDTO deleteFlight(String flightNumber);

    List<FlightDTO> getFlights();
}
