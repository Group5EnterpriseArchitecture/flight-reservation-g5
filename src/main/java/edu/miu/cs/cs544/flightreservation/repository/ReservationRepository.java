package edu.miu.cs.cs544.flightreservation.repository;

import edu.miu.cs.cs544.flightreservation.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("select distinct r from Reservation r where r.reservedBy.id = :id")
    List<Reservation> getOwnReservation(Long id);

    Reservation getReservationByReservationCode(String reservationCode);

}
