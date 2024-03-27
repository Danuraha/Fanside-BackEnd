package org.ticketreservation.moviefan.service;

import org.ticketreservation.moviefan.dao.response.JwtAuthenticationResponse;
import org.ticketreservation.moviefan.dao.request.SignUpRequest;
import org.ticketreservation.moviefan.dao.request.SigninRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
