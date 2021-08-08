package edu.miu.cs.cs544.flightreservation.service;

import edu.miu.cs.cs544.flightreservation.DTO.AirlineDTO;
import edu.miu.cs.cs544.flightreservation.DTO.AirportDTO;
import edu.miu.cs.cs544.flightreservation.DTO.FlightDTO;
import edu.miu.cs.cs544.flightreservation.domain.Flight;

import java.time.LocalDateTime;

public class FlightAdapter {

    public static FlightDTO getFlightDTOFromFlight(Flight flight) {
        AirportDTO airportArrivalDTO = AirportAdapter.getAirportDTOFromAirport(flight.getArrival());
        AirportDTO airportDepartureDTO = AirportAdapter.getAirportDTOFromAirport(flight.getDeparture());
        AirlineDTO airlineDTO = AirlineAdapter.getAirlineDTOFromAirline(flight.getOperateBy());
        FlightDTO flightDTO = new FlightDTO(flight.getFlightNumber(), flight.getCapacity(), airportArrivalDTO, airportDepartureDTO,
                flight.getDepartureTime(), flight.getArrivalTime(), airlineDTO);
        return flightDTO;
    }

}
