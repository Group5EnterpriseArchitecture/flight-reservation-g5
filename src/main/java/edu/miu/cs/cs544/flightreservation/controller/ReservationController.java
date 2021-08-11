package edu.miu.cs.cs544.flightreservation.controller;

import edu.miu.cs.cs544.flightreservation.DTO.domain.ReservationDTO;
import edu.miu.cs.cs544.flightreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    //4. View list of own reservations
    @GetMapping("/user/reservations")
    @PreAuthorize("hasAnyRole('ADMIN', 'PASSENGER', 'AGENT')")
    ResponseEntity<?> getOwnReservations(Authentication authentication) {
        return new ResponseEntity<>(
                reservationService.getOwnReservations(authentication.getName()),
                HttpStatus.OK);
    }

    //5. View details of a reservation (flights, departure times, etc.)
    @GetMapping("/user/reservations/{reservationCode}")
    ResponseEntity<?> getOwnReservationDetails(@PathVariable String reservationCode) {
        return new ResponseEntity<>(
                reservationService.getOwnReservationDetails(reservationCode, null),
                HttpStatus.OK);
    }

    // Accessing details of a reservation onl if done by this agent
    @GetMapping("/agent/reservations/{reservationCode}")
    public ReservationDTO getOwnReservationDetailsForAgent(@PathVariable String reservationCode,
                                                           Authentication authentication) {
        return reservationService.getOwnReservationDetails(reservationCode, authentication.getName());
    }

    //6. Make a reservation (note: payload will be a list of flights)
    @PostMapping("/reservations")
    ResponseEntity<?> addReservation(@RequestBody ReservationDTO reservationDTO) {
        return new ResponseEntity<>(
                reservationService.addReservation(reservationDTO, null),
                HttpStatus.CREATED);
    }

    @PostMapping("/user/reservations")
    @PreAuthorize("hasAnyRole('ADMIN', 'PASSENGER', 'AGENT')")
    ResponseEntity<?> addLoggedInReservation(@RequestBody ReservationDTO reservationDTO, Authentication authentication) {
        return new ResponseEntity<>(
                reservationService.addReservation(reservationDTO, authentication.getName()),
                HttpStatus.CREATED);
    }

    //7. Cancel a reservation
    @PatchMapping("/reservations/{reservationCode}/cancellation")
    ResponseEntity<?> cancelReservation(@PathVariable String reservationCode) {
        return new ResponseEntity<>(
                reservationService.cancelReservation(reservationCode),
                HttpStatus.OK);
    }

    /*8. Confirm and purchase a reservation. This will result in multiple tickets
            (one for each flight in the reservation)*/
    @PatchMapping("/reservations/{reservationCode}/payment")
    ResponseEntity<?> purchaseReservation(@PathVariable String reservationCode) {
        return new ResponseEntity<>(
                reservationService.purchaseReservation(reservationCode),
                HttpStatus.OK);
    }

    //---------------------------------------------all crud operations------------------------------------------------
    @GetMapping("/reservations")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<?> getAllReservations() {
        return new ResponseEntity<>(reservationService.getAllReservations(), HttpStatus.OK);
    }
}
