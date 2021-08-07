package edu.miu.cs.cs544.flightreservation.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EStatus status;
}
