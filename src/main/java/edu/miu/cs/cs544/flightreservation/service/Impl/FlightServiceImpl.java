package edu.miu.cs.cs544.flightreservation.service.Impl;

import edu.miu.cs.cs544.flightreservation.DTO.FlightDTO;
import edu.miu.cs.cs544.flightreservation.domain.Flight;
import edu.miu.cs.cs544.flightreservation.repository.AirlineRepository;
import edu.miu.cs.cs544.flightreservation.repository.AirportRepository;
import edu.miu.cs.cs544.flightreservation.repository.FlightRepository;
import edu.miu.cs.cs544.flightreservation.service.FlightAdapter;
import edu.miu.cs.cs544.flightreservation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
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
        if(airportRepository.getAirportByCode(flightDTO.getDepartureAirportCode()) == null ||
        airportRepository.getAirportByCode(flightDTO.getArrivalAirportCode()) == null ||
        airlineRepository.getAirlineByCode(flightDTO.getOperateBy()) == null) {
            return new FlightDTO();
        }
        Flight flightToBeAdded = FlightAdapter.getFlightFromFlightDTO(flightDTO, airportRepository, airlineRepository);
        return FlightAdapter.getFlightDTOFromFlight(flightRepository.save(flightToBeAdded));
    }

    @Override
    public List<FlightDTO> getFlights(String departure, String arrival, LocalDate departureTime) {

        List<Flight> flights = flightRepository.getSpecificFlight(departure, arrival, departureTime.atStartOfDay(), departureTime.plusDays(1).atStartOfDay());
        return flights.stream().map(FlightAdapter::getFlightDTOFromFlight)
                .collect(Collectors.toList());
    }

    @Override
    public FlightDTO updateFlight(String flightNumber, Flight flight) {
        Flight flightToBeUpdated = flightRepository.getFlightByFlightNumber(flightNumber);

            flightToBeUpdated.setFlightNumber(flight.getFlightNumber());
            flightToBeUpdated.setArrival(flight.getArrival());
            flightToBeUpdated.setArrivalTime(flight.getArrivalTime());
            flightToBeUpdated.setDeparture(flight.getDeparture());
            flightToBeUpdated.setCapacity(flight.getCapacity());
            flightToBeUpdated.setDepartureTime(flight.getDepartureTime());
            flightToBeUpdated.setOperateBy(flight.getOperateBy());

           return FlightAdapter.getFlightDTOFromFlight(flightRepository.save(flightToBeUpdated));

    }

    @Override
    public boolean deleteFlight(String flightNumber) {
        Flight flightToBeDeleted = flightRepository.getFlightByFlightNumber(flightNumber);
            flightRepository.delete(flightToBeDeleted);
        return true;
    }

    @Override
    public List<FlightDTO> getFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream().map(FlightAdapter::getFlightDTOFromFlight)
                .collect(Collectors.toList());
    }
}
