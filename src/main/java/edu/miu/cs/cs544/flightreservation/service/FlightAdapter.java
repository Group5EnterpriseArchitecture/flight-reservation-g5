package edu.miu.cs.cs544.flightreservation.service;

import edu.miu.cs.cs544.flightreservation.DTO.AirlineDTO;
import edu.miu.cs.cs544.flightreservation.DTO.AirportDTO;
import edu.miu.cs.cs544.flightreservation.DTO.FlightDTO;
import edu.miu.cs.cs544.flightreservation.domain.Airline;
import edu.miu.cs.cs544.flightreservation.domain.Airport;
import edu.miu.cs.cs544.flightreservation.domain.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FlightAdapter {

    public static FlightDTO getFlightDTOFromFlight(Flight flight) {
        AirportDTO airportArrivalDTO = AirportAdapter.getAirportDTOFromAirport(flight.getArrival());
        AirportDTO airportDepartureDTO = AirportAdapter.getAirportDTOFromAirport(flight.getDeparture());
        AirlineDTO airlineDTO = AirlineAdapter.getAirlineDTOFromAirline(flight.getOperateBy());
        FlightDTO flightDTO = new FlightDTO(flight.getFlightNumber(), flight.getCapacity(), airportArrivalDTO, airportDepartureDTO,
                flight.getDepartureTime(), flight.getArrivalTime(), airlineDTO);
        return flightDTO;
    }

    public static Flight getFlightFromFlightDTO(FlightDTO flightDTO) {
        Airport airportArrival = AirportAdapter.getAirportFromAirportDTO(flightDTO.getArrival());
        Airport airportDeparture = AirportAdapter.getAirportFromAirportDTO(flightDTO.getDeparture());
        Airline airline = AirlineAdapter.getAirlineFromAirlineDTO(flightDTO.getOperateBy());
        Flight flight = new Flight(flightDTO.getFlightNumber(), flightDTO.getCapacity(), airportArrival, airportDeparture,
                flightDTO.getDepartureTime(), flightDTO.getArrivalTime(), airline);
        return flight;
    }

    public static List<FlightDTO> getListFlightDTOFromListFlight(List<Flight> flights){
        return flights.stream().map(f -> getFlightDTOFromFlight(f)).collect(Collectors.toList());
    }

    public static List<Flight> getListFlightFromListFlightDTO(List<FlightDTO> flights){
        return flights.stream().map(f -> getFlightFromFlightDTO(f)).collect(Collectors.toList());
    }

}
