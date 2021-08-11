package edu.miu.cs.cs544.flightreservation.controller;

import edu.miu.cs.cs544.flightreservation.DTO.domain.AirportDTO;
import edu.miu.cs.cs544.flightreservation.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping(value = "/airports", params = "fetch-all-true")
    ResponseEntity<?> getAllAirports() {
        return new ResponseEntity<>(airportService.getAllAirports(), HttpStatus.OK);
    }

    @GetMapping("/airports")
    ResponseEntity<?> getAirportsPage(Pageable pageable) {
        return new ResponseEntity<>(airportService.getAllAirports(pageable), HttpStatus.OK);
    }

    @PostMapping("/airports")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<?> addAirports(@RequestBody @Valid AirportDTO airportDTO) {
        return new ResponseEntity<>(airportService.addAirport(airportDTO), HttpStatus.CREATED);
    }

    @PutMapping("/airports/{code}")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<?> updateAirports(@PathVariable String code, @RequestBody @Valid AirportDTO airportDTO) {
        return new ResponseEntity<>(airportService.updateAirport(code, airportDTO), HttpStatus.OK);
    }

    @DeleteMapping("/airports/{code}")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<?> deleteAirports(@PathVariable String code) {
        airportService.deleteAirport(code);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
