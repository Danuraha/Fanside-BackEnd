package org.ticketreservation.moviefan.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Time;

@Entity
@Getter
@Setter
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showtimeId;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @DateTimeFormat
    private Time startTime;
//
    @DateTimeFormat
    private Time endTime;
    private Date showdate;
    private int availableSeats;

    private double price;

    // Setters and getters omitted for brevity
}
