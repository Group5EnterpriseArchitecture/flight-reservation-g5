package edu.miu.cs.cs544.flightreservation.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightNumber;
    private Integer capacity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Airport departure;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Airport arrival;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Airline operateBy;

    public Flight(String flightNumber,
                  Integer capacity,
                  Airport departure,
                  Airport arrival,
                  LocalDateTime departureTime,
                  LocalDateTime arrivalTime,
                  Airline operateBy) {
        this.flightNumber = flightNumber;
        this.capacity = capacity;
        this.departure = departure;
        this.arrival = arrival;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.operateBy = operateBy;
    }
}
