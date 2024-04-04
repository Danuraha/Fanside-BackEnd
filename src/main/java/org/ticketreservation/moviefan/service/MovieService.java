package org.ticketreservation.moviefan.service;

import org.ticketreservation.moviefan.entities.Movie;


import java.util.List;


public interface MovieService {
     void saveMovie(Movie movObj);

     List<Movie> getMovie(Long movieId);

     void deleteMovie(Long movieId);

}
