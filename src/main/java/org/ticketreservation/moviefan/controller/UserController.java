package org.ticketreservation.moviefan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.ticketreservation.moviefan.Exception.UserAlreadyExistsException;
import org.ticketreservation.moviefan.dao.LoginForm;
import org.ticketreservation.moviefan.dao.UserRepo;
import org.ticketreservation.moviefan.model.User;
import org.ticketreservation.moviefan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.ticketreservation.moviefan.model.User;

@RestController
//@RequestMapping("/v1/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService service;


@PostMapping("/register")
public ResponseEntity<String> register(@RequestBody User user) throws Exception {
//    return service.saveUser(user);
    try {
        service.saveUser(user);
        System.out.println("User registered successfully.");
        return ResponseEntity.ok("User registered successfully.");
    }catch (UserAlreadyExistsException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while registering the user.");
    }
}
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
