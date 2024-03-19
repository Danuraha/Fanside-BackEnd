package org.ticketreservation.moviefan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ticketreservation.moviefan.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
