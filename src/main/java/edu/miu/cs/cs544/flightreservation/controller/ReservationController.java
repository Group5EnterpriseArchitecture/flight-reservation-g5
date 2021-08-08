package edu.miu.cs.cs544.flightreservation.controller;

import edu.miu.cs.cs544.flightreservation.domain.Reservation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReservationController {

    //4. View list of own reservations
    @GetMapping("/passengers/{id}/reservations")
    public void getOwnReservations(@PathVariable String id){

    }

    //5. View details of a reservation (flights, departure times, etc.)
    @GetMapping("/passengers/{id}/reservations/{reservationCode}")
    public void getOwnReservationDetails(@PathVariable String id,@PathVariable String reservationCode){

    }

    //6. Make a reservation (note: payload will be a list of flights)
    @PostMapping("/reservations")
    public void addReservation(@RequestBody Reservation reservation){

    }

    //7. Cancel a reservation
    @PatchMapping("/reservations/{reservationCode}/cancellation")
    public void cancelReservation(@PathVariable String reservationCode, @RequestBody Reservation reservation){

    }

    /*8. Confirm and purchase a reservation. This will result in multiple tickets
            (one for each flight in the reservation)*/
    @PatchMapping("/reservations/{reservationCode}/payment")
    public void purchaseReservation(@PathVariable String reservationCode, @RequestBody Reservation reservation){

    }

    //---------------------------------------------all crud operations------------------------------------------------
    @GetMapping("/reservations")
    public void getAllReservations(){

    }



}
