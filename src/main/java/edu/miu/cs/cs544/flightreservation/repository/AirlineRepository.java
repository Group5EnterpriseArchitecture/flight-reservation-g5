package edu.miu.cs.cs544.flightreservation.repository;

import edu.miu.cs.cs544.flightreservation.domain.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface AirlineRepository extends JpaRepository<Airline, Long> {
    Airline getAirlineByCode(String code);

    Optional<Airline> findAirlineByCode(String code);

    @Query("select distinct f.operateBy from Flight f where f.departure.code = :code")
    List<Airline> getAllAirlinesDepartingFromAirport(String code);
}
