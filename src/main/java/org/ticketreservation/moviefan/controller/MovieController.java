package org.ticketreservation.moviefan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.ticketreservation.moviefan.entities.Movie;
import org.ticketreservation.moviefan.service.MovieService;

import java.util.List;
@RequiredArgsConstructor
@RestController
//@PreAuthorize("hasRole('USER')")
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/save")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movObj){
        movieService.saveMovie(movObj);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @PreAuthorize("hasAnyAuthority('user:read')")
    @GetMapping(value = {"/getMovie","/{movieId}"})
    public List<Movie> getMovie(@PathVariable(required = false)Long movieId){
        return movieService.getMovie(movieId);
    }

    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<Movie> removeMovie(@PathVariable Long movieId){
        movieService.deleteMovie(movieId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
