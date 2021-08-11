package edu.miu.cs.cs544.flightreservation.service;

import edu.miu.cs.cs544.flightreservation.DTO.domain.AirportDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AirportService {
    List<AirportDTO> getAllAirports();
    Page<AirportDTO> getAllAirports(Pageable pageable);
    AirportDTO addAirport(AirportDTO airportDTO);
    AirportDTO updateAirport(String code, AirportDTO airportDTO);
    void deleteAirport(String code);
}
