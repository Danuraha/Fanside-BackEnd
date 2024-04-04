package org.ticketreservation.moviefan.Exception;

public class SeatBookingNotFoundException extends RuntimeException{
    public SeatBookingNotFoundException(String message) {
        super(message);
    }
}
