package edu.miu.cs.cs544.flightreservation.service.Impl;

import edu.miu.cs.cs544.flightreservation.DTO.domain.ReservationDTO;
import edu.miu.cs.cs544.flightreservation.DTO.domain.TicketDTO;
import edu.miu.cs.cs544.flightreservation.domain.*;
import edu.miu.cs.cs544.flightreservation.repository.*;
import edu.miu.cs.cs544.flightreservation.service.ReservationAdapter;
import edu.miu.cs.cs544.flightreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<ReservationDTO> getAllReservations() {
        return ReservationAdapter.getListReservationDTOFromListReservation(reservationRepository.findAll());
    }

    public ReservationDTO addReservation(ReservationDTO reservationDTO, String username) {
        Reservation reservation;
        List<Flight> itinerary = reservationDTO.getItinerary().stream().map(fn -> flightRepository.getFlightByFlightNumber(fn)).collect(Collectors.toList());

        if(username != null) {
            Long personID = userCredentialsRepository.getPersonIdByUsername(username);
            Person person = personRepository.getPersonById(personID);
            reservation = ReservationAdapter.getReservationFromReservationDTO(reservationDTO, itinerary);
            reservation.setReservedBy(person);
        } else {
            reservation = ReservationAdapter.getReservationFromReservationDTO(reservationDTO, itinerary);
        }

        return ReservationAdapter.getReservationDTOFromReservation(reservationRepository.save(reservation));
    }

    @Override
    public List<ReservationDTO> getOwnReservations(String username) {
        Long personID = userCredentialsRepository.getPersonIdByUsername(username);
        return ReservationAdapter.getListReservationDTOFromListReservation(reservationRepository.getOwnReservation(personID));
    }

    @Override
    public ReservationDTO getOwnReservationDetails(String reservationCode) {
        return ReservationAdapter.getReservationDTOFromReservation(reservationRepository.getReservationByReservationCode(reservationCode));
    }

    @Override
    public ReservationDTO cancelReservation(String reservationCode) {
        Reservation reservation = reservationRepository.getReservationByReservationCode(reservationCode);
        if (!reservation.getStatus().equals(EStatus.PENDING)) {
            return null;
        }
        reservation.setStatus(EStatus.CANCELLED);
        return ReservationAdapter.getReservationDTOFromReservation(reservation);
    }

    @Override
    public List<TicketDTO> purchaseReservation(String reservationCode) {
        Reservation reservation = reservationRepository.getReservationByReservationCode(reservationCode);
        if (!reservation.getStatus().equals(EStatus.PENDING)) {
            return new ArrayList<>();
        }
        reservation.setStatus(EStatus.PAID);
        List<Ticket> tickets = reservation.getItinerary().stream().map(f -> new Ticket(String.valueOf(Math.random()),
                reservation, f.getDepartureTime(), f)).collect(Collectors.toList());
        ticketRepository.saveAll(tickets);
        return tickets.stream().map(TicketDTO::new).collect(Collectors.toList());

    }

}
