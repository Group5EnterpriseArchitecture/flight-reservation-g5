package edu.miu.cs.cs544.flightreservation.controller;

import edu.miu.cs.cs544.flightreservation.domain.Airport;
import edu.miu.cs.cs544.flightreservation.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/airports")
    ResponseEntity<?> getAllAirports(){
        return new ResponseEntity<>(airportService.getAllAirports(), HttpStatus.OK);
    }

    @PostMapping("/airports")
    ResponseEntity<?> addAirports(@RequestBody Airport airport){
        return new ResponseEntity<>(airportService.addAirport(airport), HttpStatus.CREATED);
    }

    @PutMapping("/airports/{code}")
    ResponseEntity<?> updateAirports(@PathVariable String code, @RequestBody Airport airport){
        return new ResponseEntity<>(airportService.updateAirport(code, airport), HttpStatus.OK);
    }

    @DeleteMapping("/airports/{code}")
    ResponseEntity<?> deleteAirports(@PathVariable String code){
        airportService.deleteAirport(code);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
