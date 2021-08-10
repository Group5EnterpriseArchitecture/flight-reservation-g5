package edu.miu.cs.cs544.flightreservation.service.Impl;

import edu.miu.cs.cs544.flightreservation.DTO.domain.AirlineDTO;
import edu.miu.cs.cs544.flightreservation.domain.Airline;
import edu.miu.cs.cs544.flightreservation.exception.ResourceNotFoundException;
import edu.miu.cs.cs544.flightreservation.repository.AirlineRepository;
import edu.miu.cs.cs544.flightreservation.service.AirlineAdapter;
import edu.miu.cs.cs544.flightreservation.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    @Override
    public List<AirlineDTO> getAllAirlines() {
        List<Airline> airlines = airlineRepository.findAll();
        return airlines
                .stream()
                .map(AirlineAdapter::getAirlineDTOFromAirline)
                .collect(Collectors.toList());

    }

    @Override
    public AirlineDTO addAirline(Airline airline) {
        airlineRepository.save(airline);
        return AirlineAdapter.getAirlineDTOFromAirline(airline);
    }

    @Override
    public AirlineDTO updateAirline(String code, Airline airline) {
        Airline foundAirline = airlineRepository.findAirlineByCode(code)
                .map(a -> {
                    a.setName(airline.getName());
                    a.setCode(airline.getCode());
                    a.setHistory(airline.getHistory());
                    return airlineRepository.save(a);
                }).orElseThrow(() -> new ResourceNotFoundException("Airline with code " + code + " NOT FOUND"));
        return AirlineAdapter.getAirlineDTOFromAirline(foundAirline);
    }

    @Override
    public void deleteAirline(String code) {
        Airline foundAirline = airlineRepository.findAirlineByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Airline with code " + code + " NOT FOUND"));
        airlineRepository.delete(foundAirline);
    }
}
