package org.ticketreservation.moviefan.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.ticketreservation.moviefan.models.Pokemon;

import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    Optional<Pokemon> findByType(String type);
}
