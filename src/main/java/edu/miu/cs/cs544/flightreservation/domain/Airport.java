package edu.miu.cs.cs544.flightreservation.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    @Embedded
    private Address address;

    public Airport(String code, String name, Address address) {
        this.code = code;
        this.name = name;
        this.address = address;
    }
}
