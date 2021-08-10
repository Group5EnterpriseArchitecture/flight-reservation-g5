package edu.miu.cs.cs544.flightreservation.service;

import edu.miu.cs.cs544.flightreservation.DTO.domain.AirportDTO;
import edu.miu.cs.cs544.flightreservation.domain.Airport;

import java.util.List;

public interface AirportService {
    List<AirportDTO> getAllAirports();
    AirportDTO addAirport(Airport airport);
    AirportDTO updateAirport(String code, Airport airport);
    void deleteAirport(String code);
}
