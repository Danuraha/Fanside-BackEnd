package org.ticketreservation.moviefan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ticketreservation.moviefan.entities.Movie;
import org.ticketreservation.moviefan.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public void saveMovie(Movie movObj){
        movieRepository.save(movObj);
    }

    public List<Movie> getMovie(Long movieId){
        if(null!=movieId){
            return movieRepository.findAllByMovieId(movieId);

        }else {
            return movieRepository.findAll();
        }
    }

    public void deleteMovie(Long movieId){
        movieRepository.deleteById(movieId);
    }
}
