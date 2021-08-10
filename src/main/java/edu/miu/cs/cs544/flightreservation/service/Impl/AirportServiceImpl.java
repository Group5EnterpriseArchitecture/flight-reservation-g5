package edu.miu.cs.cs544.flightreservation.service.Impl;

import edu.miu.cs.cs544.flightreservation.DTO.domain.AirportDTO;
import edu.miu.cs.cs544.flightreservation.domain.Airport;
import edu.miu.cs.cs544.flightreservation.exception.ResourceNotFoundException;
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

    @Override
    public AirportDTO updateAirport(String code, Airport airport) {
        Airport foundAirport = airportRepository.findAirportByCode(code)
                .map(a -> {
                    a.setName(airport.getName());
                    a.setCode(airport.getCode());
                    a.setAddress(airport.getAddress());
                    return airportRepository.save(a);
                }).orElseThrow(ResourceNotFoundException::new); // TODO: Handle this exception
        return AirportAdapter.getAirportDTOFromAirport(foundAirport);
    }

    @Override
    public void deleteAirport(String code) {
        Airport foundAirport = airportRepository.findAirportByCode(code)
                .orElseThrow(ResourceNotFoundException::new);
        airportRepository.delete(foundAirport);
    }


}
