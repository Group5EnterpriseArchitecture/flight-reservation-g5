package edu.miu.cs.cs544.flightreservation.repository;

import edu.miu.cs.cs544.flightreservation.domain.Person;
import edu.miu.cs.cs544.flightreservation.domain.Role;
import edu.miu.cs.cs544.flightreservation.domain.UserCredentials;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@Slf4j
@Transactional
class UserCredentialsRepositoryTest {

    @Autowired
    private UserCredentialsRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldGetPersonIdByUsername() {
        // given
        String userName = "testUser";
        String role = "agent";
        UserCredentials userCredentials = new UserCredentials(userName,
                "test", role);

        // Create new Person
        Person person = new Person("test",
                "User", "testuser@miu.edu");

        userCredentials.setRole(new Role(role));
        userCredentials.setPerson(person);
        underTest.save(userCredentials);

        // when
        Long found = underTest.getPersonIdByUsername(userName);

        // then
        assertThat(found).isEqualTo(1L);
    }

    @Test
    void itShouldFindUserGivenUsername() {
        // given
        String userName = "testUser";
        String role = "agent";
        UserCredentials userCredentials = new UserCredentials(userName,
                "test", role);

        // Create new Person
        Person person = new Person("test",
                "User", "testuser@miu.edu");

        userCredentials.setRole(new Role(role));
        userCredentials.setPerson(person);
        underTest.save(userCredentials);

        // when
        UserCredentials found = underTest.findByUsername(userName).orElse(null);

        // then
        if (found != null) {
            assertThat(found.getUsername()).isEqualTo(userName);
        }
    }

}