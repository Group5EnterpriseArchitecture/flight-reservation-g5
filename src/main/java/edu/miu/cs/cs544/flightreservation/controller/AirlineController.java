package edu.miu.cs.cs544.flightreservation.controller;

import edu.miu.cs.cs544.flightreservation.DTO.domain.AirlineDTO;
import edu.miu.cs.cs544.flightreservation.domain.Airline;
import edu.miu.cs.cs544.flightreservation.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AirlineController {

    @Autowired
    AirlineService airlineService;

    @GetMapping("/airlines")
    public List<AirlineDTO> getAllAirlines(){
        return airlineService.getAllAirlines();
    }

    @GetMapping("/airlines/{departureAirportCode}")
    public List<AirlineDTO> getAllAirlinesDepartFromAirport(@PathVariable String departureAirportCode){
        return airlineService.getAllAirlinesDepartFromAirport(departureAirportCode);
    }

    @PostMapping("/airlines")
    @PreAuthorize("hasRole('ADMIN')")
    public AirlineDTO addAirlines(@RequestBody Airline airline){
        return airlineService.addAirline(airline);
    }

    @PutMapping("/airlines/{code}")
    @PreAuthorize("hasRole('ADMIN')")
    public AirlineDTO updateAirlines(@PathVariable String code, @RequestBody Airline airline){
        return airlineService.updateAirline(code, airline);
    }

    @DeleteMapping("/airlines/{code}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAirlines(@PathVariable String code){
        airlineService.deleteAirline(code);
    }
}
