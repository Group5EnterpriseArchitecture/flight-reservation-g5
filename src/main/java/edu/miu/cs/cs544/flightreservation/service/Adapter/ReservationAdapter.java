package edu.miu.cs.cs544.flightreservation.service.Adapter;

import edu.miu.cs.cs544.flightreservation.DTO.domain.ReservationDTO;
import edu.miu.cs.cs544.flightreservation.domain.EStatus;
import edu.miu.cs.cs544.flightreservation.domain.Flight;
import edu.miu.cs.cs544.flightreservation.domain.Reservation;
import edu.miu.cs.cs544.flightreservation.utils.Randomizer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationAdapter {
    public static ReservationDTO getReservationDTOFromReservation(Reservation reservation) {
        List<String> itineraryCodes = reservation.getItinerary()
                .stream().map(Flight::getFlightNumber).collect(Collectors.toList());
        return new ReservationDTO(reservation.getReservationCode(),
                PersonAdapter.getPersonDTOFromPerson(reservation.getPassenger()), itineraryCodes,
                FlightAdapter.getListFlightDTOFromListFlight(reservation.getItinerary()),
                reservation.getReservationDateTime());
    }

    public static List<ReservationDTO> getListReservationDTOFromListReservation(List<Reservation> reservations) {
        return reservations.stream().map(ReservationAdapter::getReservationDTOFromReservation).collect(Collectors.toList());
    }

    public static Reservation getReservationFromReservationDTO(ReservationDTO reservationDTO, List<Flight> itinerary) {

        Reservation reservation = new Reservation(
                Randomizer.generateAlphaNumericCode(6),
                PersonAdapter.getPersonFromPersonDTO(reservationDTO.getPassenger()),
                itinerary,
                reservationDTO.getReservationDateTime(),
                null, EStatus.PENDING, null);
        reservation.setReservationDateTime(LocalDateTime.now());
        reservation.setReservedBy(reservation.getPassenger());

        return reservation;
    }

}
