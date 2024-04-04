package org.ticketreservation.moviefan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ticketreservation.moviefan.entities.Movie;

import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    List<Movie> findAllByMovieId(long movieId);
}
