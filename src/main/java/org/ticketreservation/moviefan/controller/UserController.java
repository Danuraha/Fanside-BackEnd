package org.ticketreservation.moviefan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.ticketreservation.moviefan.Exception.UserAlreadyExistsException;
import org.ticketreservation.moviefan.model.User;
import org.ticketreservation.moviefan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.ticketreservation.moviefan.model.User;

@RestController
public class UserController {
    @Autowired
    private UserService service;



@PostMapping("/register")
public ResponseEntity<String> register(@RequestBody User user) throws Exception {
//    return service.saveUser(user);
    try {
        service.saveUser(user);
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
