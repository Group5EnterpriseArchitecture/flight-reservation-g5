package edu.miu.cs.cs544.flightreservation.service.Adapter;

import edu.miu.cs.cs544.flightreservation.DTO.domain.FlightDTO;
import edu.miu.cs.cs544.flightreservation.domain.Airline;
import edu.miu.cs.cs544.flightreservation.domain.Airport;
import edu.miu.cs.cs544.flightreservation.domain.Flight;
import edu.miu.cs.cs544.flightreservation.repository.AirlineRepository;
import edu.miu.cs.cs544.flightreservation.repository.AirportRepository;

import java.util.List;
import java.util.stream.Collectors;

public class FlightAdapter {

    public static FlightDTO getFlightDTOFromFlight(Flight flight) {
        String departureAirportCode = flight.getArrival().getCode();
        String arrivalAirportCode = flight.getDeparture().getCode();
        String operateBy = flight.getOperateBy().getCode();
        return new FlightDTO(
                flight.getFlightNumber(),
                flight.getCapacity(),
                arrivalAirportCode, departureAirportCode,
                flight.getDepartureTime(), flight.getArrivalTime(), operateBy);
    }

    public static Flight getFlightFromFlightDTO(FlightDTO flightDTO, AirportRepository airportRepository, AirlineRepository airlineRepository) {
        Airport airportArrival = airportRepository.getAirportByCode(flightDTO.getArrivalAirportCode());
        Airport airportDeparture = airportRepository.getAirportByCode(flightDTO.getDepartureAirportCode());
        Airline airline = airlineRepository.getAirlineByCode(flightDTO.getOperateBy());
        return new Flight(
                flightDTO.getFlightNumber(),
                flightDTO.getCapacity(),
                airportArrival, airportDeparture,
                flightDTO.getDepartureTime(),
                flightDTO.getArrivalTime(), airline);
    }

    public static List<FlightDTO> getListFlightDTOFromListFlight(List<Flight> flights) {
        return flights.stream().map(FlightAdapter::getFlightDTOFromFlight).collect(Collectors.toList());
    }

    public static List<Flight> getListFlightFromListFlightDTO(List<FlightDTO> flights,
                                                              AirportRepository airportRepository,
                                                              AirlineRepository airlineRepository) {
        return flights
                .stream()
                .map(f -> getFlightFromFlightDTO(f, airportRepository, airlineRepository))
                .collect(Collectors.toList());
    }

}
