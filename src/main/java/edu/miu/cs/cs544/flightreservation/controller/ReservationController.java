package edu.miu.cs.cs544.flightreservation.controller;

import edu.miu.cs.cs544.flightreservation.DTO.domain.ReservationDTO;
import edu.miu.cs.cs544.flightreservation.DTO.domain.TicketDTO;
import edu.miu.cs.cs544.flightreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


    //4. View list of own reservations
    @GetMapping("/passengers/{id}/reservations")
    public List<ReservationDTO> getOwnReservations(@PathVariable String id){
        return reservationService.getOwnReservations(id);
    }

    //5. View details of a reservation (flights, departure times, etc.)
    @GetMapping("/passengers/{id}/reservations/{reservationCode}")
    public void getOwnReservationDetails(@PathVariable String id,@PathVariable String reservationCode){

    }

    //6. Make a reservation (note: payload will be a list of flights)
    @PostMapping("/reservations")
    public ReservationDTO addReservation(@RequestBody ReservationDTO reservationDTO){
        return reservationService.addReservation(reservationDTO);
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
    public List<ReservationDTO> getAllReservations(){
        return reservationService.getAllReservations();
    }
}
