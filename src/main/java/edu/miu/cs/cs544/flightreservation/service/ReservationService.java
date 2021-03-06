package edu.miu.cs.cs544.flightreservation.service;

import edu.miu.cs.cs544.flightreservation.DTO.domain.ReservationDTO;
import edu.miu.cs.cs544.flightreservation.DTO.domain.TicketDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReservationService {
    List<ReservationDTO> getAllReservations();
    Page<ReservationDTO> getAllReservations(Pageable pageable);
    ReservationDTO addReservation(ReservationDTO reservationDTO, String username);
    List<ReservationDTO> getOwnReservations(String username);
    ReservationDTO cancelReservation(String reservationCode);
    List<TicketDTO> purchaseReservation(String reservationCode);
    ReservationDTO getOwnReservationDetails(String reservationCode, String username);
    ReservationDTO getReservationByCode(String reservationCode);
}
