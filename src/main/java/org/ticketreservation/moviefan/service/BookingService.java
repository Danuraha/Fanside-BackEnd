package org.ticketreservation.moviefan.service;


import org.ticketreservation.moviefan.dao.booking.Bookingdto;
import org.ticketreservation.moviefan.entities.Booking;


import java.util.Optional;


public interface BookingService {

    void saveBooking(Bookingdto bookingdto) throws Exception;

    Optional<Booking> getBookingById(Long bookingId);


}
