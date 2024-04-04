package org.ticketreservation.moviefan.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


import java.util.Set;
@Data
@Entity
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cinemaId;

    private String name;
    private String location;
    private int numSeats;
    private String description;

    @OneToMany(mappedBy = "cinema")
    @JsonIgnore // This prevents infinite recursion
    private Set<Showtime> showtimes;

}
