package org.ticketreservation.moviefan.controller;

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
public User register(@RequestBody User user){
    return service.saveUser(user);
}
}
