package edu.miu.cs.cs544.flightreservation.service.Impl;

import edu.miu.cs.cs544.flightreservation.DTO.AirportDTO;
import edu.miu.cs.cs544.flightreservation.domain.Airport;
import edu.miu.cs.cs544.flightreservation.repository.AirportRepository;
import edu.miu.cs.cs544.flightreservation.service.AirportAdapter;
import edu.miu.cs.cs544.flightreservation.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public List<AirportDTO> getAllAirports() {
        List<Airport> airports = airportRepository.findAll();
        return airports
                .stream()
                .map(AirportAdapter::getAirportDTOFromAirport)
                .collect(Collectors.toList());

    }

    @Override
    public AirportDTO addAirport(Airport airport) {
        airportRepository.save(airport);
        return AirportAdapter.getAirportDTOFromAirport(airport);
    }


}
