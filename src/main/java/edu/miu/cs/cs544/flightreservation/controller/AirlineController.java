package edu.miu.cs.cs544.flightreservation.controller;

import edu.miu.cs.cs544.flightreservation.DTO.AirlineDTO;
import edu.miu.cs.cs544.flightreservation.domain.Airline;
import edu.miu.cs.cs544.flightreservation.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/airlines")
    public AirlineDTO addAirlines(@RequestBody Airline airline){
        return airlineService.addAirline(airline);
    }

    @PutMapping("/airlines/{code}")
    public AirlineDTO updateAirlines(@PathVariable String code, @RequestBody Airline airline){
        return airlineService.updateAirline(code, airline);
    }

    @DeleteMapping("/airlines/{code}")
    public void deleteAirlines(@PathVariable String code){
        airlineService.deleteAirline(code);
    }
}
