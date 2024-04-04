package org.ticketreservation.moviefan.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ticketreservation.moviefan.entities.Showtime;
import org.ticketreservation.moviefan.repository.ShowtimeRepository;
import org.ticketreservation.moviefan.service.ShowtimeService;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ShowtimeServiceImpl implements ShowtimeService {

    private final ShowtimeRepository showtimeRepository;

    public Showtime saveShowtime(Showtime showtime) {

        return showtimeRepository.save(showtime);
    }

    public void deleteShowtime(Long showtimeId) {

        showtimeRepository.deleteById(showtimeId);
    }

    public Optional<Showtime> getShowtimeById(Long showtimeId) {

        return showtimeRepository.findById(showtimeId);
    }



    public Optional<List<Showtime>> getByMovie(Long movieId) {
        return showtimeRepository.findByMovieMovieId(movieId);


    }
    public Optional<List<Showtime>> getByCinema(Long cinemaId){
        return showtimeRepository.findByCinemaCinemaId(cinemaId);

    }
}
