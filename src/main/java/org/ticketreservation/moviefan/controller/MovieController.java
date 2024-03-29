package org.ticketreservation.moviefan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ticketreservation.moviefan.entities.Movie;
import org.ticketreservation.moviefan.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/save")
    public ResponseEntity createMovie(@RequestBody Movie movObj){
        movieService.saveMovie(movObj);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping(value = {"/getMovie","/{movieId}"})
    public List<Movie> getMovie(@PathVariable(required = false)Long movieId){
        return movieService.getMovie(movieId);
    }

    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity removeMovie(@PathVariable Long movieId){
        movieService.deleteMovie(movieId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
