package edu.miu.cs.cs544.flightreservation.security.service;

import edu.miu.cs.cs544.flightreservation.DTO.security.request.LoginRequestDTO;
import edu.miu.cs.cs544.flightreservation.DTO.security.request.SignupRequestDTO;
import edu.miu.cs.cs544.flightreservation.DTO.security.response.GenericResponseDTO;

public interface AuthenticationService {
    GenericResponseDTO authenticateUser(LoginRequestDTO request);

    GenericResponseDTO registerUser(SignupRequestDTO request);
}
