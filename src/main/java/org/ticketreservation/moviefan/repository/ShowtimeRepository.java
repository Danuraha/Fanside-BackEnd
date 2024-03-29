package org.ticketreservation.moviefan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.ticketreservation.moviefan.entities.Cinema;
import org.ticketreservation.moviefan.entities.Showtime;

import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime,Long> {

    List<Showtime> findAllByShowtimeId(long showtimeId);
    List<Showtime> findByCinema(Cinema cinema);

}
