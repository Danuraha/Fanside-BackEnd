package org.ticketreservation.moviefan.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.ticketreservation.moviefan.dao.UserRepo;
import org.ticketreservation.moviefan.model.User;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12); //4th
public User saveUser(User user){
    user.setPassword(encoder.encode(user.getPassword())); //3rd
    System.out.println(user.getPassword()); //2nd
    return repo.save(user);
}
}
