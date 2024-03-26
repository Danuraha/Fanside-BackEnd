package org.ticketreservation.moviefan.dao;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class LoginForm {
    @Id
//    private int id;
    private String username;
    private String password;

    // Getters and setters
}
