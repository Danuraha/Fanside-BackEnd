package org.ticketreservation.moviefan.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String title;
    private String description;
//    private Date releaseDate;
    private String genre;

    // Setters and getters omitted for brevity
//@JsonIgnore
//    @ManyToMany(mappedBy = "assignedMovie")
//    private Set<Cinema> cinemaSet=new HashSet<>();
//    @OneToMany(mappedBy = "movie")
//    private Set<Showtime> showtimes;
}
