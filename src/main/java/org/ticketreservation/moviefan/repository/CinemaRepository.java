package org.ticketreservation.moviefan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ticketreservation.moviefan.entities.Cinema;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Long> {
    List<Cinema> findAllByCinemaId(long cinemaId);
}
