package edu.miu.cs.cs544.flightreservation.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightNumber;
    private Integer capacity;

    @ManyToOne(cascade = CascadeType.ALL)
    private Airport departure;

    @ManyToOne(cascade = CascadeType.ALL)
    private Airport arrival;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    @ManyToOne(cascade = CascadeType.ALL)
    private Airline operateBy;

}
