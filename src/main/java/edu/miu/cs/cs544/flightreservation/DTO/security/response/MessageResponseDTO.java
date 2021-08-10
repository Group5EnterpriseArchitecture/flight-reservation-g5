package edu.miu.cs.cs544.flightreservation.DTO.security.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponseDTO {
    private String message;

    public MessageResponseDTO(String message) {
        this.message = message;
    }

    public GenericResponseDTO getResponse(String status) {
        return new GenericResponseDTO(status, this);
    }
}
