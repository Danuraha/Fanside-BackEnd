package org.ticketreservation.moviefan.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;

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

    // Setters and getters omitted for brevity

    @ManyToMany
    @JoinTable(name = "movie_cinema",
            joinColumns = @JoinColumn(name = "cinema_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> assignedMovie=new HashSet<>();
//    @OneToMany(mappedBy = "cinema")
//    private Set<Showtime> showtimes;
}
