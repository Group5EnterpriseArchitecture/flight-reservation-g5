package edu.miu.cs.cs544.flightreservation.service;

import edu.miu.cs.cs544.flightreservation.DTO.AddressDTO;
import edu.miu.cs.cs544.flightreservation.DTO.PersonDTO;
import edu.miu.cs.cs544.flightreservation.domain.Person;

import java.time.LocalDate;

public class PersonAdapter {

    public static PersonDTO getPersonDTOFromPerson(Person person){
        return new PersonDTO(person.getFirstName(),person.getLastName(),person.getBirthDate(),person.getEmail(),
                AddressAdapter.getAddressDTOFromAddress(person.getResidenceAddress()));
    }

    public static Person getPersonFromPersonDTO(PersonDTO personDTO){
        return new Person(personDTO.getFirstName(),personDTO.getLastName(),personDTO.getBirthDate(),personDTO.getEmail(),
                AddressAdapter.getAddressFromAddressDTO(personDTO.getResidenceAddressDTO()));
    }
}
