package edu.miu.cs.cs544.flightreservation.service.Impl;

import edu.miu.cs.cs544.flightreservation.DTO.FlightDTO;
import edu.miu.cs.cs544.flightreservation.domain.Flight;
import edu.miu.cs.cs544.flightreservation.repository.FlightRepository;
import edu.miu.cs.cs544.flightreservation.service.FlightAdapter;
import edu.miu.cs.cs544.flightreservation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Override
    public FlightDTO addFlight(Flight flight) {
        return FlightAdapter.getFlightDTOFromFlight(flightRepository.save(flight));
    }

    @Override
    public List<FlightDTO> getFlights(String departure, String arrival, LocalDateTime departureTime) {
        List<Flight> flights = flightRepository.getSpecificFlight(departure, arrival, departureTime);
        return flights.stream().map(FlightAdapter::getFlightDTOFromFlight)
                .collect(Collectors.toList());
    }


    @Override
    public FlightDTO updateFlight(String flightNumber, Flight flight) {
        return null;
    }

    @Override
    public FlightDTO deleteFlight(String flightNumber) {
        return null;
    }

    @Override
    public List<FlightDTO> getFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream().map(FlightAdapter::getFlightDTOFromFlight)
                .collect(Collectors.toList());
    }
}
