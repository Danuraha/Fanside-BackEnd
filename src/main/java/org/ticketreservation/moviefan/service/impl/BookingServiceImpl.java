package org.ticketreservation.moviefan.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.ticketreservation.moviefan.Exception.SeatAlreadyBookedException;
import org.ticketreservation.moviefan.Exception.ShowNotFoundException;
import org.ticketreservation.moviefan.Exception.UserNotFoundException;
import org.ticketreservation.moviefan.dao.booking.BookingDto;
import org.ticketreservation.moviefan.entities.Booking;
import org.ticketreservation.moviefan.entities.SeatReservation;
import org.ticketreservation.moviefan.entities.Showtime;
import org.ticketreservation.moviefan.entities.User;
import org.ticketreservation.moviefan.repository.BookingRepository;
import org.ticketreservation.moviefan.service.BookingService;
import org.ticketreservation.moviefan.service.ShowtimeService;
import org.ticketreservation.moviefan.service.UserDetailsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserDetailsService userDetailsService;
    private final ShowtimeService showtimeService;
    @Transactional
    @Override
    public Long saveBooking(BookingDto bookingdto) throws RuntimeException {
        if (bookingRepository.existsBookingForSeatInShow(bookingdto.getSeatId(), bookingdto.getShowId()) > 0) {
            log.info("seat booked");
            throw new SeatAlreadyBookedException("Seat booked");
        }
        Booking booking = new Booking();
        Optional<Showtime> showtimeOptional = showtimeService.getShowtimeById(bookingdto.getShowId());
        if (showtimeOptional.isPresent()) {
            Showtime showtime = showtimeOptional.get();
            booking.setShowtime(showtime);
        } else {
            throw new ShowNotFoundException("Showtime details not found for ID: " + bookingdto.getShowId());
        }
        Optional<User> userOptional = userDetailsService.getByUser(bookingdto.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            booking.setUser(user);
        } else {
            throw new UserNotFoundException("User details not found for ID: " + bookingdto.getEmail());
        }
        List<SeatReservation> seatReservations = new ArrayList<>();
        bookingdto.getSeatId().forEach(s -> seatReservations.add(new SeatReservation(booking, s)));

        booking.setSeatReservations(seatReservations);
        booking.setTotalAmount(bookingdto.getTotalAmount());
        bookingRepository.save(booking);
        return booking.getBookingId();
    }
    public Optional<Booking> getBookingById(@PathVariable Long bookingId) {
        return bookingRepository.findAllByBookingId(bookingId);
    }
}
