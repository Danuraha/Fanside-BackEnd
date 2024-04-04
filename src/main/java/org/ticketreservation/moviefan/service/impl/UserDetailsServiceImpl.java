package org.ticketreservation.moviefan.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ticketreservation.moviefan.dao.userDetails.UserDetailsdto;
import org.ticketreservation.moviefan.entities.User;
import org.ticketreservation.moviefan.repository.UserRepository;
import org.ticketreservation.moviefan.service.UserDetailsService;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserRepository userRepository;
    public Optional<User> getByUser(String  email) {

        return userRepository.findByEmail(email);
    }

    public Optional<User> updateDetails(UserDetailsdto userDetailsdto) {
        Optional<User> oldData = userRepository.findByEmail(userDetailsdto.getEmail());

        if (oldData.isPresent()) {
            User oldUser = oldData.get();

            // Set new values from the user object provided by the frontend
            oldUser.setFirstName(userDetailsdto.getFirstName());
            oldUser.setLastName(userDetailsdto.getLastName());
            oldUser.setAddress(userDetailsdto.getAddress());
            oldUser.setGender(userDetailsdto.getGender());
            oldUser.setPhoneNumber(userDetailsdto.getPhoneNumber());
            // Save the updated user
            User updatedUser = userRepository.save(oldUser);

            return Optional.of(updatedUser);
        }

        return Optional.empty();
    }

}
