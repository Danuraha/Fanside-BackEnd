package org.ticketreservation.moviefan.service;

import org.ticketreservation.moviefan.dao.userDetails.UserDetailsDto;
import org.ticketreservation.moviefan.entities.User;


import java.util.Optional;
public interface UserDetailsService {
     Optional<User> getByUser(String email) ;
     Optional<User> updateDetails(UserDetailsDto userDetailsdto) ;


}
