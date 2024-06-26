package org.ticketreservation.moviefan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ticketreservation.moviefan.dao.userDetails.UserDetailsDto;
import org.ticketreservation.moviefan.entities.User;
import org.ticketreservation.moviefan.service.UserDetailsService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class UserController {
    private final UserDetailsService userDetailsService;
    @GetMapping("/{email}")
    public ResponseEntity<Optional<User>> getByUser(@PathVariable String email) {
        Optional<User> user = userDetailsService.getByUser(email);
        if (user.isPresent()) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/save")
    public ResponseEntity<User> updateDetails(@RequestBody UserDetailsDto userDetailsdto) {
        Optional<User> updatedUser = userDetailsService.updateDetails(userDetailsdto);

        return updatedUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
