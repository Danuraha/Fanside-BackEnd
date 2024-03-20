package org.ticketreservation.moviefan.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.ticketreservation.moviefan.models.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
