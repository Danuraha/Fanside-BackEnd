package org.ticketreservation.moviefan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.ticketreservation.moviefan.entities.Cinema;
import org.ticketreservation.moviefan.entities.Showtime;

import java.util.List;
import java.util.Optional;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {

    List<Showtime> findAllByShowtimeId(long showtimeId);

        List<Showtime> findByCinema(Cinema cinema);
    @Query(" select  s from Showtime  s join  fetch s.movie join fetch  s.cinema where s.movie.movieId=?1")
    Optional<List<Showtime>> findByMovieId(Long movieId);



//    Optional<List<Showtime>> findByMovieMovieId(long movieId);
    Optional<List<Showtime>> findByCinemaCinemaId(long cinemaId);

}
