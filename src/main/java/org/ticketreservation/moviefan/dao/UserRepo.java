package org.ticketreservation.moviefan.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.ticketreservation.moviefan.model.User;

public interface UserRepo extends JpaRepository<User,Integer> {
User findByUsername(String username);
}
