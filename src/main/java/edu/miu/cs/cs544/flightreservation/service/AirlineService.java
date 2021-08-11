package edu.miu.cs.cs544.flightreservation.service;

import edu.miu.cs.cs544.flightreservation.DTO.domain.AirlineDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AirlineService {
    List<AirlineDTO> getAllAirlines();
    Page<AirlineDTO> getAllAirlines(Pageable pageable);
    AirlineDTO addAirline(AirlineDTO airlineDTO);
    AirlineDTO updateAirline(String code, AirlineDTO airlineDTO);
    void deleteAirline(String code);
    List<AirlineDTO> getAllAirlinesDepartFromAirport(String departureAirportCode);
}
