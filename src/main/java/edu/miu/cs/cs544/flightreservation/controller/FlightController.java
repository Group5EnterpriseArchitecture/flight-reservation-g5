package edu.miu.cs.cs544.flightreservation.controller;

import edu.miu.cs.cs544.flightreservation.DTO.domain.FlightDTO;
import edu.miu.cs.cs544.flightreservation.domain.Flight;
import edu.miu.cs.cs544.flightreservation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightController {

    @Autowired
    private FlightService flightService;

    //3. View list of flights between a departure and destination for a date
    @GetMapping("/flights")
    @PreAuthorize("hasRole('ADMIN')")
    public List<FlightDTO> getFlightsFromToInaDate(
            @RequestParam(value = "departure", required = false) String departure,
            @RequestParam(value = "arrival", required = false) String arrival,
            @RequestParam(value = "departureDate", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate) {

        if(departure == null || arrival == null || departureDate == null) {
            return flightService.getFlights();
        }

       return flightService.getFlights(departure, arrival, departureDate);
    }


    @PostMapping("/flights")
    public FlightDTO addFlight(@RequestBody FlightDTO flightDTO){
       return flightService.addFlight(flightDTO);
    }

    @PutMapping("/flights/{flightNumber}")
    public FlightDTO updateFlight(@PathVariable String flightNumber, @RequestBody Flight flight){
        return flightService.updateFlight(flightNumber,flight);
    }

    @DeleteMapping("/flights/{flightNumber}")
    public boolean deleteFlight(@PathVariable String flightNumber){
        return flightService.deleteFlight(flightNumber);
    }
}
