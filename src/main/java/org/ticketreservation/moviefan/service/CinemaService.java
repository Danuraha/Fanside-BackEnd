package org.ticketreservation.moviefan.service;


import org.ticketreservation.moviefan.entities.Cinema;
import org.ticketreservation.moviefan.entities.Movie;


import java.util.*;


public interface CinemaService {
     void saveCinema(Cinema cinObj);

     List<Cinema> getCinema(Long cinemaId);

     void deleteCinema(Long cinemaId);

     List<Movie> getMoviesByCinemaId(Long cinemaId) ;

}
