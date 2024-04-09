package org.ticketreservation.moviefan.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @ManyToOne
    @JoinColumn(name="booking_id",nullable = false)
    private Booking booking;

    private  String seatId;


    public SeatReservation(Booking booking, String s) {
        this.booking=booking;
        this.seatId=s;
    }
}
