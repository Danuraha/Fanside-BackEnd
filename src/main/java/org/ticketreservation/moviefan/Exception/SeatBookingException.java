package org.ticketreservation.moviefan.Exception;

public class SeatBookingException extends RuntimeException {

    public SeatBookingException(String message) {
        super(message);
    }
}

// Similar structure for SeatUnavailableException and SeatBookingNotFoundException
