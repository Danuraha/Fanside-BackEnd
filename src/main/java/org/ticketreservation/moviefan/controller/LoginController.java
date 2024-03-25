//package org.ticketreservation.moviefan.controller;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.csrf.CsrfToken;
//import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.ticketreservation.moviefan.Security.JwtTokenProvider;
//import org.ticketreservation.moviefan.dao.LoginForm;
//@RestController
//@NoArgsConstructor
//@AllArgsConstructor
//public class LoginController {
//
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;
//
//    @PostMapping("/loginU")
//    public ResponseEntity<String> login(@RequestBody LoginForm loginForm) {
//
//        System.out.println(loginForm.getUsername());
//        // Authenticate user
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
//
//        // Set authentication in SecurityContext
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        // Generate JWT token
//        String jwtToken = jwtTokenProvider.generateToken(authentication);
//        System.out.println(jwtToken);
//
//        // Return JWT token in response
//        return ResponseEntity.ok(jwtToken);
//    }
//}