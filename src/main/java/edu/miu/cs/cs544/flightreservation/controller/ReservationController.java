package edu.miu.cs.cs544.flightreservation.controller;

import edu.miu.cs.cs544.flightreservation.DTO.domain.ReservationDTO;
import edu.miu.cs.cs544.flightreservation.DTO.security.response.GenericResponseDTO;
import edu.miu.cs.cs544.flightreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/user/reservations")
    @PreAuthorize("hasAnyRole('ADMIN', 'PASSENGER', 'AGENT')")
    ResponseEntity<?> getOwnReservations(Authentication authentication) {
        return new ResponseEntity<>(
                reservationService.getOwnReservations(authentication.getName()),
                HttpStatus.OK);
    }

    @GetMapping("/reservations/{reservationCode}")
    ResponseEntity<?> getReservationDetailsByCode(@PathVariable String reservationCode) {
        return new ResponseEntity<>(
                reservationService.getReservationByCode(reservationCode),
                HttpStatus.OK);
    }

    @GetMapping("/user/reservations/{reservationCode}")
    @PreAuthorize("hasAnyRole('AGENT', 'ADMIN', 'PASSENGER')")
    public ReservationDTO getOwnReservationDetails(@PathVariable String reservationCode,
                                                   Authentication authentication) {
        return reservationService.getOwnReservationDetails(reservationCode, authentication.getName());
    }

    @PostMapping("/reservations")
    ResponseEntity<?> addReservation(@RequestBody @Valid ReservationDTO reservationDTO) {
        return new ResponseEntity<>(
                reservationService.addReservation(reservationDTO, null),
                HttpStatus.CREATED);
    }

    @PostMapping("/user/reservations")
    @PreAuthorize("hasAnyRole('ADMIN', 'PASSENGER', 'AGENT')")
    ResponseEntity<?> addLoggedInReservation(@RequestBody @Valid ReservationDTO reservationDTO, Authentication authentication) {
        return new ResponseEntity<>(
                reservationService.addReservation(reservationDTO, authentication.getName()),
                HttpStatus.CREATED);
    }

    @PatchMapping("/reservations/{reservationCode}/cancellation")
    @PreAuthorize("hasAnyRole('PASSENGER', 'AGENT', 'ADMIN')")
    ResponseEntity<?> cancelReservation(@PathVariable String reservationCode) {
        return new ResponseEntity<>(
                new GenericResponseDTO("Successfully Cancelled",
                        reservationService.cancelReservation(reservationCode)),
                HttpStatus.OK);
    }

    @PatchMapping("/reservations/{reservationCode}/payment")
    ResponseEntity<?> purchaseReservation(@PathVariable String reservationCode) {
        return new ResponseEntity<>(
                new GenericResponseDTO("Purchase Successful",
                        reservationService.purchaseReservation(reservationCode)),
                HttpStatus.OK);
    }

    @GetMapping(value = "/reservations", params = "fetch-all-true")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<?> getAllReservations() {
        return new ResponseEntity<>(reservationService.getAllReservations(), HttpStatus.OK);
    }

    @GetMapping("/reservations")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<?> getReservationsPage(Pageable pageable) {
        return new ResponseEntity<>(reservationService.getAllReservations(pageable), HttpStatus.OK);
    }

    // TODO: implement Update Reservation

}
