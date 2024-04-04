package org.ticketreservation.moviefan.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ticketreservation.moviefan.entities.Movie;
import org.ticketreservation.moviefan.repository.MovieRepository;
import org.ticketreservation.moviefan.service.MovieService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

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
