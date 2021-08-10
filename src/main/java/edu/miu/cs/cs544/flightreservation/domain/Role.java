package edu.miu.cs.cs544.flightreservation.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private ERole name;

    public Role(String name) {
        this.name = ERole.valueOf("ROLE_" + name.toUpperCase());
    }
}