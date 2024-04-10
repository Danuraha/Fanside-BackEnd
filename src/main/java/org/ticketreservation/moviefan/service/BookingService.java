package org.ticketreservation.moviefan.service;


import org.springframework.web.bind.annotation.PathVariable;
import org.ticketreservation.moviefan.dao.booking.BookingDto;
import org.ticketreservation.moviefan.entities.Booking;


import java.util.Optional;


public interface BookingService {
    Long saveBooking(BookingDto bookingdto) throws Exception;
    Optional<Booking> getBookingById(@PathVariable Long bookingId);


}
