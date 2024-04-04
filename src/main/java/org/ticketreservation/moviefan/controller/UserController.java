package org.ticketreservation.moviefan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ticketreservation.moviefan.entities.User;
import org.ticketreservation.moviefan.service.UserDetailsService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class UserController {

    private final UserDetailsService userDetailsService;
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getByUser(@PathVariable Long id) {
        Optional<User> user = userDetailsService.getByUser(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/save")
    public ResponseEntity<User> updateDetails(@RequestBody User user) {
        Optional<User> updatedUser = userDetailsService.updateDetails(user);

        if (updatedUser.isPresent()) {
            return ResponseEntity.ok(updatedUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
