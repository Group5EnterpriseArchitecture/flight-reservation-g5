package edu.miu.cs.cs544.flightreservation.controller;

import edu.miu.cs.cs544.flightreservation.domain.Flight;
import org.springframework.web.bind.annotation.*;

public class FlightController {

    //3. View list of flights between a departure and destination for a date
    @GetMapping("/flights")
    public void getFlightsFromToInaDate(@RequestParam(value = "departure", required = false) String departure,
                                        @RequestParam(value = "arrival", required = false) String arrival,
                                        @RequestParam(value = "departureTime", required = false) String departureTime) {

        //if three params is null return all flights

    }


    @PostMapping("/flights")
    public void addFlight(@RequestBody Flight flight){

    }

    @PutMapping("/flights/{flightNumber}")
    public void updateFlight(@PathVariable String flightNumber, @RequestBody Flight flight){

    }

    @DeleteMapping("/flights/{flightNumber}")
    public void deleteFlight(@PathVariable String flightNumber){

    }
}
