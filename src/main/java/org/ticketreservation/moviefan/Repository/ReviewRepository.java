package org.ticketreservation.moviefan.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.ticketreservation.moviefan.models.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByPokemonId(int pokemonId);
}
