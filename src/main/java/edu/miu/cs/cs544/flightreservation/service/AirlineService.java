package edu.miu.cs.cs544.flightreservation.service;

import edu.miu.cs.cs544.flightreservation.DTO.domain.AirlineDTO;

import java.util.List;

public interface AirlineService {
    List<AirlineDTO> getAllAirlines();
    AirlineDTO addAirline(AirlineDTO airlineDTO);
    AirlineDTO updateAirline(String code, AirlineDTO airlineDTO);
    void deleteAirline(String code);
    List<AirlineDTO> getAllAirlinesDepartFromAirport(String departureAirportCode);
}
