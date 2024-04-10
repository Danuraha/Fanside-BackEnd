package org.ticketreservation.moviefan.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showtime;

    @JsonIgnore
    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
    private List<SeatReservation> seatReservations;

    @ManyToOne
    @JoinColumn(name = "user_userid")
    private User user;

    private Long totalAmount;


}