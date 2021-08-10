package edu.miu.cs.cs544.flightreservation.controller;

import edu.miu.cs.cs544.flightreservation.DTO.FlightDTO;
import edu.miu.cs.cs544.flightreservation.domain.Flight;
import edu.miu.cs.cs544.flightreservation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    public List<FlightDTO> getFlightsFromToInaDate(@RequestParam(value = "departure", required = false) String departure,
                                                   @RequestParam(value = "arrival", required = false) String arrival,
                                                   @RequestParam(value = "departureTime", required = false)
                                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureTime) {

        if(departure == null || arrival == null || departureTime == null) {
            return flightService.getFlights();
        }

       return flightService.getFlights(departure, arrival, departureTime);
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
