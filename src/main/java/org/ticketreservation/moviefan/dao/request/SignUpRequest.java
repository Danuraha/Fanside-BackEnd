package org.ticketreservation.moviefan.dao.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ticketreservation.moviefan.entities.Role;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;


}