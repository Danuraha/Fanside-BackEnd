package org.ticketreservation.moviefan.service;

import org.ticketreservation.moviefan.model.JwtAuthenticationResponse;
import org.ticketreservation.moviefan.model.SignUpRequest;
import org.ticketreservation.moviefan.model.SigninRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
