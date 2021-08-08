package edu.miu.cs.cs544.flightreservation.controller;

import edu.miu.cs.cs544.flightreservation.domain.Airline;
import org.springframework.web.bind.annotation.*;

@RestController
public class AirlineController {
    //1. View list of airports  Passenger
    @GetMapping("/airlines")
    public void getAllAirlines(){

    }

    @PostMapping("/airlines")
    public void addAirlines(@RequestBody Airline airline){

    }

    @PutMapping("/airlines/{code}")
    public void updateAirlines(@PathVariable String code, @RequestBody Airline airline){

    }

    @DeleteMapping("/airlines/{code}")
    public void deleteAirlines(@PathVariable String code){

    }
}
