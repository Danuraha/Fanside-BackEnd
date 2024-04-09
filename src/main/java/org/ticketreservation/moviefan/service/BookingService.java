package org.ticketreservation.moviefan.service;


import org.springframework.web.bind.annotation.PathVariable;
import org.ticketreservation.moviefan.dao.booking.Bookingdto;
import org.ticketreservation.moviefan.entities.Booking;


import java.util.Optional;


public interface BookingService {

    Long saveBooking(Bookingdto bookingdto) throws Exception;

//    Optional<List<Booking>> getBookingById(Long bookingId);
//public List<Long> getByShowId(Long showId);

//    public List<Booking> getAllBookingsWithSeatReservations();
public Optional<Booking> getBookingById(@PathVariable Long bookingId);


}
