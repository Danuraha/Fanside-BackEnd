package org.ticketreservation.moviefan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ticketreservation.moviefan.entities.Cinema;
import org.ticketreservation.moviefan.entities.Movie;
import org.ticketreservation.moviefan.repository.CinemaRepository;
import org.ticketreservation.moviefan.repository.MovieRepository;

import java.util.List;
import java.util.Set;

@Service
public class CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private MovieRepository movieRepository;

    public void saveCinema(Cinema cinObj){
        cinemaRepository.save(cinObj);
    }
    public List<Cinema> getCinema(Long cinemaId){
        if(null!=cinemaId){
            return cinemaRepository.findAllByCinemaId(cinemaId);
        }
        else {
            return cinemaRepository.findAll();
        }
    }

    public void deleteCinema(Long cinemaId){
        cinemaRepository.deleteById(cinemaId);
    }
    public Cinema assignCinemaToMovie(Long cinemaId,Long movieId){
        Set<Movie> movieSet=null;
        Cinema cinema=cinemaRepository.findById(cinemaId).get();
        Movie movie=movieRepository.findById(movieId).get();
        movieSet=cinema.getAssignedMovie();
        movieSet.add(movie);
        cinema.setAssignedMovie(movieSet);
        return cinemaRepository.save(cinema);
    }
}
