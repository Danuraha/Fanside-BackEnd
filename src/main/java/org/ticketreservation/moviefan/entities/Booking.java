package org.ticketreservation.moviefan.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private String seatId;

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showtime;



    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}