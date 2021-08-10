package edu.miu.cs.cs544.flightreservation.service;

import edu.miu.cs.cs544.flightreservation.DTO.domain.ReservationDTO;
import edu.miu.cs.cs544.flightreservation.DTO.domain.TicketDTO;

import java.util.List;

public interface ReservationService {
    List<ReservationDTO> getAllReservations();
    ReservationDTO addReservation(ReservationDTO reservationDTO);
    List<ReservationDTO> getOwnReservations(String id);
    ReservationDTO cancelReservation(String reservationCode);
    List<TicketDTO> purchaseReservation(String reservationCode);
}
