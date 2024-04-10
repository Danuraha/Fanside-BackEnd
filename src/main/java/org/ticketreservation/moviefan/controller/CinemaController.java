package org.ticketreservation.moviefan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ticketreservation.moviefan.entities.Cinema;
import org.ticketreservation.moviefan.entities.Movie;
import org.ticketreservation.moviefan.service.CinemaService;

import java.util.List;
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/cinema")
public class CinemaController {

    private final CinemaService cinemaService;
    @PostMapping("/save")
    public ResponseEntity<Cinema> saveCinema(@RequestBody Cinema cinObj){
        cinemaService.saveCinema(cinObj);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{cinemaId}")
    public ResponseEntity<Cinema> removeCinema(@PathVariable Long cinemaId){
        cinemaService.deleteCinema(cinemaId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


@GetMapping(value = {"/getCinema","/{cinemaId}"})
    public List<Cinema> getCinema(@PathVariable(required = false)Long cinemaId){
        return cinemaService.getCinema(cinemaId);
    }

    @GetMapping("/{cinemaId}/movies")
    public ResponseEntity<List<Movie>> getMoviesByCinemaId(@PathVariable Long cinemaId) {
        List<Movie> movies = cinemaService.getMoviesByCinemaId(cinemaId);
        return ResponseEntity.ok(movies);
    }

}
