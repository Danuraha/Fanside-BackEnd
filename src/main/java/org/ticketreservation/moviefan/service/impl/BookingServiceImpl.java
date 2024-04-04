package org.ticketreservation.moviefan.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ticketreservation.moviefan.dao.booking.Bookingdto;
import org.ticketreservation.moviefan.entities.Booking;
import org.ticketreservation.moviefan.entities.Showtime;
import org.ticketreservation.moviefan.entities.User;
import org.ticketreservation.moviefan.repository.BookingRepository;
import org.ticketreservation.moviefan.service.BookingService;
import org.ticketreservation.moviefan.service.ShowtimeService;
import org.ticketreservation.moviefan.service.UserDetailsService;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;


    private  final UserDetailsService userDetailsService;


    private final ShowtimeService showtimeService;

    public void saveBooking(Bookingdto bookingdto){
        Booking booking = new Booking(); // Assuming Booking is your entity class

        Optional<User> userOptional = userDetailsService.getByUser(bookingdto.getUserId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            booking.setUser(user);
        } else {
            throw new RuntimeException("User details not found for ID: " + bookingdto.getUserId());
        }

        Optional<Showtime> showtimeOptional = showtimeService.getShowtimeById(bookingdto.getShowId());
        if (showtimeOptional.isPresent()) {
            Showtime showtime = showtimeOptional.get();
            booking.setShowtime(showtime);
        } else {
            throw new RuntimeException("Showtime details not found for ID: " + bookingdto.getShowId());
        }
        booking.setSeatId(bookingdto.getSeatId());
        bookingRepository.save(booking);
    }


    public Optional<Booking> getBookingById(Long bookingId) {

        return bookingRepository.findByBookingId(bookingId);
    }
}
