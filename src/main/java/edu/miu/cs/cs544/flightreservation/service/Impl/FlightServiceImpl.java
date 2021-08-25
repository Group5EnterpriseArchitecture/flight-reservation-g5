package edu.miu.cs.cs544.flightreservation.service.Impl;

import edu.miu.cs.cs544.flightreservation.DTO.domain.FlightDTO;
import edu.miu.cs.cs544.flightreservation.domain.Airline;
import edu.miu.cs.cs544.flightreservation.domain.Airport;
import edu.miu.cs.cs544.flightreservation.domain.Flight;
import edu.miu.cs.cs544.flightreservation.exception.NoSuchElementFoundException;
import edu.miu.cs.cs544.flightreservation.repository.AirlineRepository;
import edu.miu.cs.cs544.flightreservation.repository.AirportRepository;
import edu.miu.cs.cs544.flightreservation.repository.FlightRepository;
import edu.miu.cs.cs544.flightreservation.service.Adapter.FlightAdapter;
import edu.miu.cs.cs544.flightreservation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    AirlineRepository airlineRepository;

    @Override
    public FlightDTO addFlight(FlightDTO flightDTO) {
        Flight flightToBeAdded = extractFlightFromDTO(flightDTO);
        return FlightAdapter.getFlightDTOFromFlight(flightRepository.save(flightToBeAdded));
    }

    @Override
    public List<FlightDTO> getFlights(String departure, String arrival, LocalDate departureDate) {

        List<Flight> flights = flightRepository.getSpecificFlight(departure, arrival,
                departureDate.atStartOfDay(), departureDate.plusDays(1).atStartOfDay());
        return flights.stream().map(FlightAdapter::getFlightDTOFromFlight)
                .collect(Collectors.toList());
    }

    @Override
    public FlightDTO updateFlight(String flightNumber, FlightDTO flightDTO) {
        Flight flight = extractFlightFromDTO(flightDTO);

        Flight flightToBeUpdated = flightRepository.getFlightByFlightNumber(flightNumber)
                .map(f -> {
                    f.setFlightNumber(flight.getFlightNumber());
                    f.setArrival(flight.getArrival());
                    f.setArrivalTime(flight.getArrivalTime());
                    f.setDeparture(flight.getDeparture());
                    f.setCapacity(flight.getCapacity());
                    f.setDepartureTime(flight.getDepartureTime());
                    f.setOperateBy(flight.getOperateBy());
                    return flightRepository.save(f);
                }).orElseThrow(() -> new NoSuchElementFoundException("Flight with Flight number " + flightNumber + " NOT FOUND"));
        return FlightAdapter.getFlightDTOFromFlight(flightToBeUpdated);
    }

    @Override
    public void deleteFlight(String flightNumber) {
        Flight flightToBeDeleted = flightRepository.getFlightByFlightNumber(flightNumber)
                .orElseThrow(() -> new NoSuchElementFoundException("Flight with flightNumber " + flightNumber + " NOT FOUND"));
        flightRepository.delete(flightToBeDeleted);
    }

    @Override
    public List<FlightDTO> getFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream().map(FlightAdapter::getFlightDTOFromFlight)
                .collect(Collectors.toList());
    }

    @Override
    public Page<FlightDTO> getAllFlights(Pageable pageable) {
        return flightRepository.findAll(pageable).map(FlightAdapter::getFlightDTOFromFlight);
    }

    private Flight extractFlightFromDTO(FlightDTO flightDTO) {
        Airport airportArrival = airportRepository
                .findAirportByCode(flightDTO.getArrivalAirportCode())
                .orElseThrow(() -> new NoSuchElementFoundException("Arrival airport code does not Exist"));
        Airport airportDeparture = airportRepository
                .findAirportByCode(flightDTO.getDepartureAirportCode())
                .orElseThrow(() -> new NoSuchElementFoundException("Departure Airport code does not Exist"));
        Airline airline = airlineRepository
                .findAirlineByCode(flightDTO.getOperateBy())
                .orElseThrow(() -> new NoSuchElementFoundException("Airline code does not Exist"));

        return FlightAdapter.getFlightFromFlightDTO(flightDTO, airportArrival, airportDeparture, airline);
    }
}
