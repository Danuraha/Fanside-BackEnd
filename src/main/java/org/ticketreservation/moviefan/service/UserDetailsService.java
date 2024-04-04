package org.ticketreservation.moviefan.service;

import org.ticketreservation.moviefan.entities.User;


import java.util.Optional;

public interface UserDetailsService {
     Optional<User> getByUser(Long id) ;
     Optional<User> updateDetails(User user) ;


}
