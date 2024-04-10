package org.ticketreservation.moviefan.Exception;

public class ShowNotFoundException extends RuntimeException{
    public ShowNotFoundException(String message) {
        super(message);
    }
}
