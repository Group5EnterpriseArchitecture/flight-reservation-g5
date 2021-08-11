package edu.miu.cs.cs544.flightreservation.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@SecondaryTable(name = "airline_history")
@Data
@NoArgsConstructor
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;

    @Column(table = "airline_history", length = 2000)
    private String history;

    public Airline(String code, String name, String history) {
        this.code = code;
        this.name = name;
        this.history = history;
    }
}
