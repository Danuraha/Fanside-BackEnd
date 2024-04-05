package org.ticketreservation.moviefan.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
//    private List<String> seatId;
//@ElementCollection
private List<String> seatId;
    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showtime;



    @ManyToOne
    @JoinColumn(name = "user_userid")
    private User user;


}