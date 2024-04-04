package org.ticketreservation.moviefan.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ticketreservation.moviefan.entities.Cinema;
import org.ticketreservation.moviefan.entities.Movie;
import org.ticketreservation.moviefan.entities.Showtime;
import org.ticketreservation.moviefan.repository.CinemaRepository;
import org.ticketreservation.moviefan.service.CinemaService;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;

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
    public List<Movie> getMoviesByCinemaId(Long cinemaId) {
        Optional<Cinema> cinemaOptional = cinemaRepository.findById(cinemaId);
        if (cinemaOptional.isPresent()) {
            Cinema cinema = cinemaOptional.get();
            Set<Showtime> showtimes = cinema.getShowtimes(); // List of associated showtimes

            List<Movie> movies = new ArrayList<>();
            for (Showtime showtime : showtimes) {
                movies.add(showtime.getMovie()); // Assuming each showtime has a movie
            }
            return movies;
        } else {
            return Collections.emptyList(); // Return empty list if cinema not found
        }
    }
}
