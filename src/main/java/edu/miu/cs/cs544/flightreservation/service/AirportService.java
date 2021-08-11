package edu.miu.cs.cs544.flightreservation.service;

import edu.miu.cs.cs544.flightreservation.DTO.domain.AirportDTO;

import java.util.List;

public interface AirportService {
    List<AirportDTO> getAllAirports();
    AirportDTO addAirport(AirportDTO airportDTO);
    AirportDTO updateAirport(String code, AirportDTO airportDTO);
    void deleteAirport(String code);
}
