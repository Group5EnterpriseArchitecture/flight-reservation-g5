package edu.miu.cs.cs544.flightreservation.service.Impl;

import edu.miu.cs.cs544.flightreservation.DTO.domain.AirlineDTO;
import edu.miu.cs.cs544.flightreservation.domain.Airline;
import edu.miu.cs.cs544.flightreservation.exception.NoSuchElementFoundException;
import edu.miu.cs.cs544.flightreservation.repository.AirlineRepository;
import edu.miu.cs.cs544.flightreservation.service.Adapter.AirlineAdapter;
import edu.miu.cs.cs544.flightreservation.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<AirlineDTO> getAllAirlines(Pageable pageable) {
        return airlineRepository.findAll(pageable).map(AirlineAdapter::getAirlineDTOFromAirline);
    }

    @Override
    public AirlineDTO addAirline(AirlineDTO airlineDTO) {
        Airline airline = AirlineAdapter.getAirlineFromAirlineDTO(airlineDTO);
        return AirlineAdapter.getAirlineDTOFromAirline(airlineRepository.save(airline));
    }

    @Override
    public AirlineDTO updateAirline(String code, AirlineDTO airlineDTO) {
        Airline airline = AirlineAdapter.getAirlineFromAirlineDTO(airlineDTO);
        Airline foundAirline = airlineRepository.findAirlineByCode(code)
                .map(a -> {
                    a.setName(airline.getName());
                    a.setCode(airline.getCode());
                    a.setHistory(airline.getHistory());
                    return airlineRepository.save(a);
                }).orElseThrow(() -> new NoSuchElementFoundException("Airline with code " + code + " NOT FOUND"));
        return AirlineAdapter.getAirlineDTOFromAirline(foundAirline);
    }

    @Override
    public void deleteAirline(String code) {
        Airline foundAirline = airlineRepository.findAirlineByCode(code)
                .orElseThrow(() -> new NoSuchElementFoundException("Airline with code " + code + " NOT FOUND"));
        airlineRepository.delete(foundAirline);
    }

    @Override
    public List<AirlineDTO> getAllAirlinesDepartFromAirport(String departureAirportCode) {
        return AirlineAdapter.getAirlineListDTOFromAirline(
                airlineRepository.getAllAirlinesDepartingFromAirport(departureAirportCode));
    }
}
