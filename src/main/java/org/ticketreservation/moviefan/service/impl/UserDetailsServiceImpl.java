package org.ticketreservation.moviefan.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ticketreservation.moviefan.entities.User;
import org.ticketreservation.moviefan.repository.UserRepository;
import org.ticketreservation.moviefan.service.UserDetailsService;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserRepository userRepository;
    public Optional<User> getByUser(Long id) {

        return userRepository.findById(id);
    }

    public Optional<User> updateDetails(User user) {
        Optional<User> oldData = userRepository.findById(user.getId());

        if (oldData.isPresent()) {
            User oldUser = oldData.get();

            // Set new values from the user object provided by the frontend
            oldUser.setFirstName(user.getFirstName());
            oldUser.setLastName(user.getLastName());
            oldUser.setAddress(user.getAddress());
            oldUser.setGender(user.getGender());

            // Save the updated user
            User updatedUser = userRepository.save(oldUser);

            return Optional.of(updatedUser);
        }

        return Optional.empty();
    }

}
