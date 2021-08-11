package edu.miu.cs.cs544.flightreservation.service.Adapter;

import edu.miu.cs.cs544.flightreservation.DTO.domain.AddressDTO;
import edu.miu.cs.cs544.flightreservation.DTO.domain.AirportDTO;
import edu.miu.cs.cs544.flightreservation.domain.Address;
import edu.miu.cs.cs544.flightreservation.domain.Airport;

public class AirportAdapter {

    public static Airport getAirportFromAirportDTO(AirportDTO airportDTO) {
        Airport airport = new Airport(airportDTO.getCode(),
                airportDTO.getName(), getAddressfromAddressDTO(airportDTO.getAddressDTO()));
        return airport;
    }

    public static Address getAddressfromAddressDTO(AddressDTO addressDTO){
        Address address = new Address(addressDTO.getStreet(),addressDTO.getCity(),addressDTO.getState(),
                addressDTO.getZip());
        return address;
    }

    public static AirportDTO getAirportDTOFromAirport(Airport airport) {
        AirportDTO airportDTO = new AirportDTO(airport.getCode(),
                airport.getName(), getAddressDTOFromAddress(airport.getAddress()));
        return airportDTO;
    }

    public static AddressDTO getAddressDTOFromAddress(Address address){
        AddressDTO addressDTO = new AddressDTO(address.getStreet(),address.getCity(),address.getState(),
                address.getZip());
        return addressDTO;
    }


}

