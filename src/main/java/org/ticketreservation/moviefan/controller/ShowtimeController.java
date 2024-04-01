package org.ticketreservation.moviefan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ticketreservation.moviefan.entities.Showtime;
import org.ticketreservation.moviefan.service.ShowtimeService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/showtime")

public class ShowtimeController {

    @Autowired
    private ShowtimeService showtimeService;

    @PostMapping("/save")
    public ResponseEntity<Showtime> saveShowtime(@RequestBody Showtime showtime) {
        Showtime savedShowtime = showtimeService.saveShowtime(showtime);
        return ResponseEntity.ok(savedShowtime);
    }

    @DeleteMapping("/{showtimeId}")
    public ResponseEntity<?> deleteShowtime(@PathVariable Long showtimeId) {
        showtimeService.deleteShowtime(showtimeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{showtimeId}")
    public ResponseEntity<Optional<Showtime>> getShowtimeById(@PathVariable Long showtimeId) {
        Optional<Showtime> showtime = showtimeService.getShowtimeById(showtimeId);
        if (showtime.isPresent()) {
            return ResponseEntity.ok(showtime);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getbymovieId/{movieId}")
    public Optional<List<Showtime>> getByMovieId(@PathVariable Long movieId) {
        return showtimeService.getByMovie(movieId);
    }
    @GetMapping("/getbycinemaId/{cinemaId}")
    public Optional<List<Showtime>> getByCinemaId(@PathVariable Long cinemaId){
        return showtimeService.getByCinema(cinemaId);
    }
    // You can add additional methods for listing or filtering showtimes
}

