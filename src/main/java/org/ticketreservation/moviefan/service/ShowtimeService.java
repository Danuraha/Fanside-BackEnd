package org.ticketreservation.moviefan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ticketreservation.moviefan.entities.Showtime;
import org.ticketreservation.moviefan.repository.ShowtimeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    public Showtime saveShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    public void deleteShowtime(Long showtimeId) {
        showtimeRepository.deleteById(showtimeId);
    }

    public Optional<Showtime> getShowtimeById(Long showtimeId) {
        return showtimeRepository.findById(showtimeId);
    }

    // You can add additional methods for filtering or searching showtimes


    public Optional<List<Showtime>> getByMovie(Long movieId) {
//        System.out.println();
//        return showtimeRepository.findByMovieMovieId(movieId);
return showtimeRepository.findByMovieId(movieId);


    }
    public Optional<List<Showtime>> getByCinema(Long cinemaId){
        return showtimeRepository.findByCinemaCinemaId(cinemaId);

    }
}
