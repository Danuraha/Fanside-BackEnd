package org.ticketreservation.moviefan.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String title;
    private String description;
    private String genre;
    private String descriptiveDescription;

}
