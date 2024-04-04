package org.ticketreservation.moviefan.service;

import org.ticketreservation.moviefan.entities.Showtime;

import java.util.List;
import java.util.Optional;


public interface ShowtimeService {
     Showtime saveShowtime(Showtime showtime);
     void deleteShowtime(Long showtimeId);
     Optional<Showtime> getShowtimeById(Long showtimeId);

     Optional<List<Showtime>> getByMovie(Long movieId);

     Optional<List<Showtime>> getByCinema(Long cinemaId);

}
