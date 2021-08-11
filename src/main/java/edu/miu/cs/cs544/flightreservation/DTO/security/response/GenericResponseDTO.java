package edu.miu.cs.cs544.flightreservation.DTO.security.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenericResponseDTO {
    private String status;
    private Object data;

    public GenericResponseDTO(String status, Object data) {
        this.status = status;
        this.data = data;
    }
}
