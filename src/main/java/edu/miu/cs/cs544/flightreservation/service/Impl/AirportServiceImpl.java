package edu.miu.cs.cs544.flightreservation.service.Impl;

import edu.miu.cs.cs544.flightreservation.DTO.domain.AirportDTO;
import edu.miu.cs.cs544.flightreservation.domain.Airport;
import edu.miu.cs.cs544.flightreservation.exception.NoSuchElementFoundException;
import edu.miu.cs.cs544.flightreservation.repository.AirportRepository;
import edu.miu.cs.cs544.flightreservation.service.Adapter.AirportAdapter;
import edu.miu.cs.cs544.flightreservation.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<AirportDTO> getAllAirports(Pageable pageable) {
        return airportRepository.findAll(pageable).map(AirportAdapter::getAirportDTOFromAirport);
    }

    @Override
    public AirportDTO addAirport(AirportDTO airportDTO) {
        Airport airport = AirportAdapter.getAirportFromAirportDTO(airportDTO);
        return AirportAdapter.getAirportDTOFromAirport(airportRepository.save(airport));
    }

    @Override
    public AirportDTO updateAirport(String code, AirportDTO airportDTO) {
        Airport airport = AirportAdapter.getAirportFromAirportDTO(airportDTO);
        Airport foundAirport = airportRepository.findAirportByCode(code)
                .map(a -> {
                    a.setName(airport.getName());
                    a.setCode(airport.getCode());
                    a.setAddress(airport.getAddress());
                    return airportRepository.save(a);
                }).orElseThrow(() -> new NoSuchElementFoundException("Airport with code " + code + " NOT FOUND"));
        return AirportAdapter.getAirportDTOFromAirport(foundAirport);
    }

    @Override
    public void deleteAirport(String code) {
        Airport foundAirport = airportRepository.findAirportByCode(code)
                .orElseThrow(() -> new NoSuchElementFoundException("Airport with code " + code + " NOT FOUND"));
        airportRepository.delete(foundAirport);
    }


}
