package org.ticketreservation.moviefan.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.ticketreservation.moviefan.models.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
