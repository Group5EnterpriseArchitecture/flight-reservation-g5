package edu.miu.cs.cs544.flightreservation.service.Adapter;

import edu.miu.cs.cs544.flightreservation.DTO.domain.PersonDTO;
import edu.miu.cs.cs544.flightreservation.domain.Person;

public class PersonAdapter {

    public static PersonDTO getPersonDTOFromPerson(Person person) {
        return new PersonDTO(person.getFirstName(), person.getLastName(), person.getBirthDate(), person.getEmail(),
                AddressAdapter.getAddressDTOFromAddress(person.getResidenceAddress()));
    }

    public static Person getPersonFromPersonDTO(PersonDTO personDTO) {
        return new Person(personDTO.getFirstName(), personDTO.getLastName(), personDTO.getBirthDate(), personDTO.getEmail(),
                AddressAdapter.getAddressFromAddressDTO(personDTO.getResidenceAddressDTO()));
    }

}
