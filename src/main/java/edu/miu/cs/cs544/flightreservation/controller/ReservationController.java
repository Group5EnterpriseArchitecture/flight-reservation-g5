package edu.miu.cs.cs544.flightreservation.controller;

import edu.miu.cs.cs544.flightreservation.DTO.domain.ReservationDTO;
import edu.miu.cs.cs544.flightreservation.DTO.domain.TicketDTO;
import edu.miu.cs.cs544.flightreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    //4. View list of own reservations
    @GetMapping("/user/reservations")
    @PreAuthorize("hasAnyRole('ADMIN', 'PASSENGER', 'AGENT')")
    public List<ReservationDTO> getOwnReservations(Authentication authentication){
        return reservationService.getOwnReservations(authentication.getName());
    }

    //5. View details of a reservation (flights, departure times, etc.)
    @GetMapping("/user/reservations/{reservationCode}")
    public ReservationDTO getOwnReservationDetails(@PathVariable String reservationCode){
        return reservationService.getOwnReservationDetails(reservationCode, null);
    }

    // Accessing details of a reservation onl if done by this agent
    @GetMapping("/agent/reservations/{reservationCode}")
    public ReservationDTO getOwnReservationDetailsForAgent(@PathVariable String reservationCode, Authentication authentication){
        return reservationService.getOwnReservationDetails(reservationCode, authentication.getName());
    }

    //6. Make a reservation (note: payload will be a list of flights)
    @PostMapping("/reservations")
    public ReservationDTO addReservation(@RequestBody ReservationDTO reservationDTO){
        return reservationService.addReservation(reservationDTO, null);
    }

    @PostMapping("/user/reservations")
    @PreAuthorize("hasAnyRole('ADMIN', 'PASSENGER', 'AGENT')")
    public ReservationDTO addLoggedInReservation(@RequestBody ReservationDTO reservationDTO, Authentication authentication){
        return reservationService.addReservation(reservationDTO, authentication.getName());
    }

    //7. Cancel a reservation
    @PatchMapping("/reservations/{reservationCode}/cancellation")
    public ReservationDTO cancelReservation(@PathVariable String reservationCode){
        return reservationService.cancelReservation(reservationCode);
    }

    /*8. Confirm and purchase a reservation. This will result in multiple tickets
            (one for each flight in the reservation)*/
    @PatchMapping("/reservations/{reservationCode}/payment")
    public List<TicketDTO> purchaseReservation(@PathVariable String reservationCode){
        return reservationService.purchaseReservation(reservationCode);
    }

    //---------------------------------------------all crud operations------------------------------------------------
    @GetMapping("/reservations")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ReservationDTO> getAllReservations(){
        return reservationService.getAllReservations();
    }
}
