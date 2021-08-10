package edu.miu.cs.cs544.flightreservation.repository;

import edu.miu.cs.cs544.flightreservation.domain.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AirlineRepository extends JpaRepository<Airline, Long> {
    Airline getAirlineByCode(String code);
}
