package edu.miu.cs.cs544.flightreservation.controller;

import edu.miu.cs.cs544.flightreservation.DTO.AirportDTO;
import edu.miu.cs.cs544.flightreservation.domain.Airport;
import edu.miu.cs.cs544.flightreservation.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AirportController {

    @Autowired
    private AirportService airportService;

    //1. View list of airports  Passenger
    @GetMapping("/airports")
    public List<AirportDTO> getAllAirports(){
        return airportService.getAllAirports();
    }

    @PostMapping("/airports")
    public void addAirports(@RequestBody Airport airport){

    }

    @PutMapping("/airports/{code}")
    public void updateAirports(@PathVariable String code, @RequestBody Airport airport){

    }

    @DeleteMapping("/airports/{code}")
    public void deleteAirports(@PathVariable String code){

    }


    //2. View list of airlines flying out of an airport (search by airport three letter code)
    @GetMapping("/airports/{airportCode}/airlines")
    public void getAirlinesFromAirport(@PathVariable String airportCode){

    }
}