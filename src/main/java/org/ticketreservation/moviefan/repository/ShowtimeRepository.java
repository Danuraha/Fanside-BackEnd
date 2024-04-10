package org.ticketreservation.moviefan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ticketreservation.moviefan.entities.Showtime;

import java.util.List;
import java.util.Optional;
@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    List<Showtime> findAllByShowtimeId(long showtimeId);
    Optional<List<Showtime>> findByMovieMovieId(long movieId);
    Optional<List<Showtime>> findByCinemaCinemaId(long cinemaId);


}
