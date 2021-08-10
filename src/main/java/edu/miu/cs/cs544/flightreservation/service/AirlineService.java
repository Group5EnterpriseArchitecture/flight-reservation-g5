package edu.miu.cs.cs544.flightreservation.service;

import edu.miu.cs.cs544.flightreservation.DTO.AirlineDTO;
import edu.miu.cs.cs544.flightreservation.domain.Airline;

import java.util.List;

public interface AirlineService {
    List<AirlineDTO> getAllAirlines();
    AirlineDTO addAirline(Airline airline);
    AirlineDTO updateAirline(String code, Airline airline);
    void deleteAirline(String code);
}
