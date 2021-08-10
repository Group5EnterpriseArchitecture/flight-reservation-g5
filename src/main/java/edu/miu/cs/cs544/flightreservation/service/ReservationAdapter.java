package edu.miu.cs.cs544.flightreservation.service;

import edu.miu.cs.cs544.flightreservation.DTO.ReservationDTO;
import edu.miu.cs.cs544.flightreservation.domain.EStatus;
import edu.miu.cs.cs544.flightreservation.domain.Reservation;
import edu.miu.cs.cs544.flightreservation.repository.AirlineRepository;
import edu.miu.cs.cs544.flightreservation.repository.AirportRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationAdapter {
    public static ReservationDTO getReservationDTOFromReservation(Reservation reservation){
        return new ReservationDTO(reservation.getReservationCode(), PersonAdapter.getPersonDTOFromPerson(reservation.getPassenger()),
                FlightAdapter.getListFlightDTOFromListFlight(reservation.getItinerary()),reservation.getReservationDateTime());
    }

    public static List<ReservationDTO> getListReservationDTOFromListReservation(List<Reservation> reservations){
        return reservations.stream().map(r -> getReservationDTOFromReservation(r)).collect(Collectors.toList());
    }

    public static Reservation getReservationFromReservationDTO(ReservationDTO reservationDTO, AirportRepository airportRepository, AirlineRepository airlineRepository){

        Reservation reservation = new Reservation(
                String.valueOf(Math.random()),
                PersonAdapter.getPersonFromPersonDTO(reservationDTO.getPassenger()),
                FlightAdapter.getListFlightFromListFlightDTO(reservationDTO.getItinerary(), airportRepository, airlineRepository),
                reservationDTO.getReservationDateTime(),
                null, EStatus.PENDING, null);
        reservation.setReservationDateTime(LocalDateTime.now());
        reservation.setReservedBy(reservation.getPassenger());

        return reservation;
    }


}
