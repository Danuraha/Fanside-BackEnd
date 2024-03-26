package org.ticketreservation.moviefan.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ticketreservation.moviefan.Security.JWTGenerator;
import org.ticketreservation.moviefan.dao.AuthResponseDTO;
import org.ticketreservation.moviefan.dao.LoginForm;
//import org.ticketreservation.moviefan.Security.JwtTokenProvider;

@RestController
//@RequestMapping("/api/auth") // Base path for authentication endpoints
public class LoginController {
    private  AuthenticationManager authenticationManager;
    private JWTGenerator jwtGenerator;
    public LoginController(AuthenticationManager authenticationManager, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
    }

        @PostMapping("/login")
        public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginForm loginForm) {
    //        try {
                // Authenticate user
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword())

                );
                SecurityContextHolder.getContext().setAuthentication(authentication);

    //            // Generate JWT token on successful authentication
    //            String jwtToken = jwtGenerator.generateToken(authentication);
    //
    //            LoginResponse response = new LoginResponse(jwtToken);
    //            return ResponseEntity.ok(response);
    //
    //        } catch (AuthenticationException e) {
    //            // Handle authentication failure
    //            return ResponseEntity.badRequest().body(new LoginResponse(e.getMessage()));
    //        }
                String token = jwtGenerator.generateToken(authentication);
                return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);

    //    }

    //    public static class LoginRequest {
    //        private String username;
    //        private String password;
    //
    //        public LoginRequest(String username, String password) {
    //            this.username = username;
    //            this.password = password;
    //        }
    //
    //        // Getters and setters (optional)
    //    }

    //    public static class LoginResponse {
    //        private String token;
    ////        private String message; // Optional for error messages
    //
    //        public LoginResponse(String token) {
    //            this.token = token;
    //        }


    //        public LoginResponse(String message) {
    //            this.message = message;
    //        }

            // Getters and setters
        }
}
