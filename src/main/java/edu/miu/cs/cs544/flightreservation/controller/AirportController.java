package edu.miu.cs.cs544.flightreservation.controller;

import edu.miu.cs.cs544.flightreservation.DTO.domain.AirportDTO;
import edu.miu.cs.cs544.flightreservation.domain.Airport;
import edu.miu.cs.cs544.flightreservation.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/airports")
    public List<AirportDTO> getAllAirports(){
        return airportService.getAllAirports();
    }

    @PostMapping("/airports")
    public AirportDTO addAirports(@RequestBody Airport airport){
        return airportService.addAirport(airport);
    }

    @PutMapping("/airports/{code}")
    public AirportDTO updateAirports(@PathVariable String code, @RequestBody Airport airport){
        return airportService.updateAirport(code, airport);
    }

    @DeleteMapping("/airports/{code}")
    public void deleteAirports(@PathVariable String code){
        airportService.deleteAirport(code);
    }


    //2. View list of airlines flying out of an airport (search by airport three letter code)
    @GetMapping("/airports/{airportCode}/airlines")
    public void getAirlinesFromAirport(@PathVariable String airportCode){

    }
}
