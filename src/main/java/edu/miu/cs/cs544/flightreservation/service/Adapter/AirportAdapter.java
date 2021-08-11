package edu.miu.cs.cs544.flightreservation.service.Adapter;

import edu.miu.cs.cs544.flightreservation.DTO.domain.AddressDTO;
import edu.miu.cs.cs544.flightreservation.DTO.domain.AirportDTO;
import edu.miu.cs.cs544.flightreservation.domain.Address;
import edu.miu.cs.cs544.flightreservation.domain.Airport;

public class AirportAdapter {

    public static Airport getAirportFromAirportDTO(AirportDTO airportDTO) {
        return new Airport(airportDTO.getCode(),
                airportDTO.getName(), getAddressFromAddressDTO(airportDTO.getAddressDTO()));
    }

    public static Address getAddressFromAddressDTO(AddressDTO addressDTO){
        return new Address(addressDTO.getStreet(),addressDTO.getCity(),addressDTO.getState(),
                addressDTO.getZip());
    }

    public static AirportDTO getAirportDTOFromAirport(Airport airport) {
        return new AirportDTO(airport.getCode(),
                airport.getName(), getAddressDTOFromAddress(airport.getAddress()));
    }

    public static AddressDTO getAddressDTOFromAddress(Address address){
        return new AddressDTO(address.getStreet(),address.getCity(),address.getState(),
                address.getZip());
    }

}

