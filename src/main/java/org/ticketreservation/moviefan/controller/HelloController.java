package org.ticketreservation.moviefan.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("hello")
    public String greet(HttpServletRequest request){
return "Hello World"+ request.getSession().getId();
    }

    @GetMapping("/home")
    public String Welcome(HttpServletRequest request){
        return "Welcome to the HomePage" + request.getSession().getId();
    }
}

