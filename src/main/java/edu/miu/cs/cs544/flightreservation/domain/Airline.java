package edu.miu.cs.cs544.flightreservation.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@SecondaryTable(name="airline_history")
@Data
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;

    @Column(table = "airline_history")
    private String history;

}
