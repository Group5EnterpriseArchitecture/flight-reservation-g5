package edu.miu.cs.cs544.flightreservation.repository;

import edu.miu.cs.cs544.flightreservation.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("select distinct f from Flight f where f.departure.code = :departureCode and f.arrival.code = :arrivalCode and " +
            "f.departureTime >= :time and f.departureTime < :timePlus")
    List<Flight> getSpecificFlight(String departureCode, String arrivalCode, LocalDateTime time, LocalDateTime timePlus);
    Flight getFlightByFlightNumber(String flightNumber);
}
