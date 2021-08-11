package edu.miu.cs.cs544.flightreservation.controller;

import edu.miu.cs.cs544.flightreservation.domain.Airline;
import edu.miu.cs.cs544.flightreservation.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AirlineController {

    @Autowired
    AirlineService airlineService;

    @GetMapping("/airlines")
    public ResponseEntity<?> getAllAirlines() {
        return new ResponseEntity<>(airlineService.getAllAirlines(), HttpStatus.OK);
    }

    @GetMapping("/airlines/{departureAirportCode}")
    public ResponseEntity<?> getAllAirlinesDepartFromAirport(@PathVariable String departureAirportCode) {
        return new ResponseEntity<>(
                airlineService.getAllAirlinesDepartFromAirport(departureAirportCode),
                HttpStatus.OK);
    }

    @PostMapping("/airlines")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addAirlines(@RequestBody Airline airline) {
        return new ResponseEntity<>(airlineService.addAirline(airline), HttpStatus.CREATED);
    }

    @PutMapping("/airlines/{code}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateAirlines(@PathVariable String code, @RequestBody Airline airline) {
        return new ResponseEntity<>(airlineService.updateAirline(code, airline), HttpStatus.OK);
    }

    @DeleteMapping("/airlines/{code}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteAirlines(@PathVariable String code) {
        airlineService.deleteAirline(code);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
