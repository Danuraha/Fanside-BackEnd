package org.ticketreservation.moviefan.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ticketreservation.moviefan.entities.Showtime;
import org.ticketreservation.moviefan.service.ShowtimeService;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/showtime")
@RequiredArgsConstructor
public class ShowtimeController {
    private  final ShowtimeService showtimeService;
    @PostMapping("/save")
    public ResponseEntity<Showtime> saveShowtime(@RequestBody Showtime showtime) {
        Showtime savedShowtime = showtimeService.saveShowtime(showtime);
        return ResponseEntity.ok(savedShowtime);
    }
    @DeleteMapping("/{showtimeId}")
    public ResponseEntity<Showtime> deleteShowtime(@PathVariable Long showtimeId) {
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
}

