package edu.miu.cs.cs544.flightreservation.service.Impl;

import edu.miu.cs.cs544.flightreservation.DTO.domain.ReservationDTO;
import edu.miu.cs.cs544.flightreservation.DTO.domain.TicketDTO;
import edu.miu.cs.cs544.flightreservation.domain.EStatus;
import edu.miu.cs.cs544.flightreservation.domain.Reservation;
import edu.miu.cs.cs544.flightreservation.domain.Ticket;
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
    private ReservationRepository reservationRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<ReservationDTO> getAllReservations() {
        return ReservationAdapter.getListReservationDTOFromListReservation(reservationRepository.findAll());
    }

    public ReservationDTO addReservation(ReservationDTO reservationDTO) {
        Reservation reservation = ReservationAdapter.getReservationFromReservationDTO(reservationDTO, flightRepository);
        return ReservationAdapter.getReservationDTOFromReservation(reservationRepository.save(reservation));
    }

    @Override
    public List<ReservationDTO> getOwnReservations(String id) {
         return ReservationAdapter.getListReservationDTOFromListReservation(reservationRepository.getOwnReservation(Long.valueOf(id)));
    }

    @Override
    public ReservationDTO cancelReservation(String reservationCode) {
        Reservation reservation = reservationRepository.getReservationByReservationCode(reservationCode);
        if(!reservation.getStatus().equals(EStatus.PENDING)) {
            return null;
        }
        reservation.setStatus(EStatus.CANCELLED);
        return ReservationAdapter.getReservationDTOFromReservation(reservation);
    }
    @Override
    public List<TicketDTO> purchaseReservation(String reservationCode) {
        Reservation reservation = reservationRepository.getReservationByReservationCode(reservationCode);
        if(!reservation.getStatus().equals(EStatus.PENDING)) {
            return new ArrayList<>();
        }
        reservation.setStatus(EStatus.PAID);
        List<Ticket> tickets = reservation.getItinerary().stream().map(f -> new Ticket(String.valueOf(Math.random()),
                reservation, f.getDepartureTime(), f)).collect(Collectors.toList());
        ticketRepository.saveAll(tickets);
        return tickets.stream().map(TicketDTO::new).collect(Collectors.toList());

    }

}
