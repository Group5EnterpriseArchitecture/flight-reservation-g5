package edu.miu.cs.cs544.flightreservation.service.Adapter;

import edu.miu.cs.cs544.flightreservation.DTO.domain.AirlineDTO;
import edu.miu.cs.cs544.flightreservation.domain.Airline;

import java.util.List;
import java.util.stream.Collectors;

public class AirlineAdapter {

    public static AirlineDTO getAirlineDTOFromAirline(Airline airline) {
        AirlineDTO airlineDTO = new AirlineDTO(airline.getCode(), airline.getName(), airline.getHistory());
        return airlineDTO;
    }

    public static Airline getAirlineFromAirlineDTO(AirlineDTO airlineDTO) {
        Airline airline = new Airline(airlineDTO.getCode(), airlineDTO.getName(), airlineDTO.getHistory());
        return airline;
    }

    public static List<AirlineDTO> getAirlineListDTOFromAirline(List<Airline> airlineList) {
        return airlineList.stream().map(a -> getAirlineDTOFromAirline(a)).collect(Collectors.toList());
    }

}
