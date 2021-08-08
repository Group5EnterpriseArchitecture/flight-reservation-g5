package edu.miu.cs.cs544.flightreservation.service;

import edu.miu.cs.cs544.flightreservation.DTO.AirportDTO;
import edu.miu.cs.cs544.flightreservation.domain.Airport;

import java.util.List;

public interface AirportService {
    List<AirportDTO> getAllAirports();
    AirportDTO addAirport(Airport airport);
}
