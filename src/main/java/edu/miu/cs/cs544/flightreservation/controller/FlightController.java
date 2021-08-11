package edu.miu.cs.cs544.flightreservation.controller;

import edu.miu.cs.cs544.flightreservation.DTO.domain.FlightDTO;
import edu.miu.cs.cs544.flightreservation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/flights")
    ResponseEntity<?> getFlightsFromToInaDate(
            @RequestParam(value = "departure", required = false) String departure,
            @RequestParam(value = "arrival", required = false) String arrival,
            @RequestParam(value = "departureDate", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate, Pageable pageable) {

        if (departure == null || arrival == null || departureDate == null) {
            return new ResponseEntity<>(flightService.getAllFlights(pageable), HttpStatus.OK);
        }

        return new ResponseEntity<>(
                flightService.getFlights(departure, arrival, departureDate),
                HttpStatus.OK);
    }

    @PostMapping("/flights")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<?> addFlight(@RequestBody @Valid FlightDTO flightDTO) {
        return new ResponseEntity<>(flightService.addFlight(flightDTO), HttpStatus.CREATED);
    }

    @PutMapping("/flights/{flightNumber}")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<?> updateFlight(@PathVariable String flightNumber, @RequestBody @Valid FlightDTO flightDTO) {
        return new ResponseEntity<>(flightService.updateFlight(flightNumber, flightDTO), HttpStatus.OK);
    }

    @DeleteMapping("/flights/{flightNumber}")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<?> deleteFlight(@PathVariable String flightNumber) {
        flightService.deleteFlight(flightNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
