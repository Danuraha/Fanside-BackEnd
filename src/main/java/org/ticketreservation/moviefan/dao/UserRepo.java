package org.ticketreservation.moviefan.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ticketreservation.moviefan.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
User findByUsername(String username);
}
