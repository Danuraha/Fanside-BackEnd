package org.ticketreservation.moviefan.service;

import org.ticketreservation.moviefan.dao.request.SignInRequest;
import org.ticketreservation.moviefan.dao.response.JwtAuthenticationResponse;
import org.ticketreservation.moviefan.dao.request.SignUpRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);
    JwtAuthenticationResponse signin(SignInRequest request);
}
