package org.ticketreservation.moviefan.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.ticketreservation.moviefan.Exception.UserAlreadyExistsException;
import org.ticketreservation.moviefan.dao.UserRepo;
import org.ticketreservation.moviefan.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12); //4th
public User saveUser(User user) throws Exception {
    List<User> UserData =repo.findAll();
    System.out.printf(UserData.getFirst().toString());
    for (User Olduser : UserData){
        if (user.getUsername().equals(Olduser.getUsername())){

            throw new UserAlreadyExistsException("User with username" + " " + user.getUsername() + "already exists");
        }
    }
    user.setPassword(encoder.encode(user.getPassword())); //3rd
    System.out.println(user.getPassword()); //2nd
    return repo.save(user);
}
}