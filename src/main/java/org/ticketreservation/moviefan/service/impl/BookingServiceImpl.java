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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;


    private final UserDetailsService userDetailsService;


    private final ShowtimeService showtimeService;

//    public void saveBooking(Bookingdto bookingdto) throws Exception {
//        List<Booking> bookedList = getByShowId(bookingdto.getShowId());
//        boolean isSeatBooked = bookedList.stream()
//                .anyMatch(check -> check.getSeatId().equals(bookingdto.getSeatId()));
//
//
//
//        if (isSeatBooked) {
//            throw new Exception("Seat already Booked");
//            // Seat is already booked
//        } else {
//
//            // Seat is available for booking
//            Booking booking = new Booking(); // Assuming Booking is your entity class
//
//            Optional<User> userOptional = userDetailsService.getByUser(bookingdto.getEmail()
//            );
//            if (userOptional.isPresent()) {
//                User user = userOptional.get();
//                booking.setUser(user);
//            } else {
//                throw new RuntimeException("User details not found for ID: " + bookingdto.getEmail());
//            }
//
//            Optional<Showtime> showtimeOptional = showtimeService.getShowtimeById(bookingdto.getShowId());
//            if (showtimeOptional.isPresent()) {
//                Showtime showtime = showtimeOptional.get();
//                booking.setShowtime(showtime);
//            } else {
//                throw new RuntimeException("Showtime details not found for ID: " + bookingdto.getShowId());
//            }
//
//
//            booking.setSeatId(bookingdto.getSeatId());
//            bookingRepository.save(booking);
//        }
//
//
//
//    }


    public Optional<Booking> getBookingById(Long bookingId) {

        return bookingRepository.findByBookingId(bookingId);
    }

    public List<Booking> getByShowId(Long showId) {

        return bookingRepository.findByShowtimeShowtimeId(showId);
    }

//    public boolean isBooked(Bookingdto bookingdto){
//        List<Booking> bookedList=getByShowId(bookingdto.getShowId());
//        bookedList.forEach(check -> check.getSeatId()==bookingdto.getSeatId());
//    }



    public void saveBooking(Bookingdto bookingdto) throws Exception {
        List<Booking> bookedList = getByShowId(bookingdto.getShowId());

        // Extracting seatIds from bookedList
        List<String> bookedSeatIds = bookedList.stream()
                .flatMap(booking -> booking.getSeatId().stream())
                .collect(Collectors.toList());

        // Check if any seat from bookingdto is already booked
        boolean isAnySeatBooked = bookingdto.getSeatId().stream()
                .anyMatch(seatId -> bookedSeatIds.contains(seatId));

        if (isAnySeatBooked) {
            throw new Exception("One or more seats are already booked");
        }

        Booking booking = new Booking();

        // Populate user and showtime
        Optional<User> userOptional = userDetailsService.getByUser(bookingdto.getEmail());
        User user = userOptional.orElseThrow(() -> new RuntimeException("User details not found for email: " + bookingdto.getEmail()));
        booking.setUser(user);

        Optional<Showtime> showtimeOptional = showtimeService.getShowtimeById(bookingdto.getShowId());
        Showtime showtime = showtimeOptional.orElseThrow(() -> new RuntimeException("Showtime details not found for ID: " + bookingdto.getShowId()));
        booking.setShowtime(showtime);

        // Assign the list of seat IDs to the booking entity
        booking.setSeatId(bookingdto.getSeatId());

        bookingRepository.save(booking);
    }
}
