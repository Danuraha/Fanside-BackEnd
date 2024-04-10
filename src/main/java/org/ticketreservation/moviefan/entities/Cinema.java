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
    private String description;
    private String descriptiveDescription;
    @OneToMany(mappedBy = "cinema")
    @JsonIgnore
    private Set<Showtime> showtimes;

}
