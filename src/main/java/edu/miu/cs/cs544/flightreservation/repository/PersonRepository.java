package edu.miu.cs.cs544.flightreservation.repository;

import edu.miu.cs.cs544.flightreservation.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Boolean existsByEmail(String email);
}
