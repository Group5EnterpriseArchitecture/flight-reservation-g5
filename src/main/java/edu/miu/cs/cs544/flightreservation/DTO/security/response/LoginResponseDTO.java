package edu.miu.cs.cs544.flightreservation.DTO.security.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {
    private String token;
    private String username;
    private String email;
    private String role;

    public LoginResponseDTO(String accessToken, String username,
                            String email, String role) {
        this.token = accessToken;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public GenericResponseDTO getResponse(String status) {
        return new GenericResponseDTO(status, this);
    }
}
