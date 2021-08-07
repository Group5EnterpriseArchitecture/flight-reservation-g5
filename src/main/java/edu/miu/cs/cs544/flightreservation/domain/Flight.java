package edu.miu.cs.cs544.flightreservation.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightNumber;
    private Integer capacity;

    @ManyToOne
    private Airport departure;

    @ManyToOne
    private Airport arrival;
    private LocalTime departureTime;
    private LocalTime arrivalTime;

    @ManyToOne
    private Airline operateBy;

}
