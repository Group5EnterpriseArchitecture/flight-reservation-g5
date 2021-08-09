package edu.miu.cs.cs544.flightreservation.service;

import edu.miu.cs.cs544.flightreservation.DTO.AddressDTO;
import edu.miu.cs.cs544.flightreservation.domain.Address;

public class AddressAdapter {
    public static AddressDTO getAddressDTOFromAddress(Address address){
        return new AddressDTO(address.getStreet(), address.getCity(), address.getState(), address.getZip());
    }

    public static Address getAddressFromAddressDTO(AddressDTO addressDTO){
        return new Address(addressDTO.getStreet(), addressDTO.getCity(), addressDTO.getState(), addressDTO.getZip());
    }
}
