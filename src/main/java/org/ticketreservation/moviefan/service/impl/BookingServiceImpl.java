package org.ticketreservation.moviefan.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.ticketreservation.moviefan.dao.booking.Bookingdto;
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


//    public List<Long> getByShowId(Long showId) {
//
//        return bookingRepository.findBookingIdsByShowtimeId(showId);
//    }


//    public boolean isBooked(Bookingdto bookingdto){
//        List<Booking> bookedList=getByShowId(bookingdto.getShowId());
//        bookedList.forEach(check -> check.getSeatId()==bookingdto.getSeatId());
//    }


//    public void saveBooking(Bookingdto bookingdto) throws Exception {
//        List<Booking> bookedList = getByShowId(bookingdto.getShowId());
//
//        // Extracting seatIds from bookedList
//        List<String> bookedSeatIds = bookedList.stream()
//                .flatMap(booking -> booking.getSeatId().stream())
//                .collect(Collectors.toList());
//
//        // Check if any seat from bookingdto is already booked
//        boolean isAnySeatBooked = bookingdto.getSeatId().stream()
//                .anyMatch(seatId -> bookedSeatIds.contains(seatId));
//
//        if (isAnySeatBooked) {
//            throw new Exception("One or more seats are already booked");
//        }
//
//        Booking booking = new Booking();
//
//        // Populate user and showtime
//        Optional<User> userOptional = userDetailsService.getByUser(bookingdto.getEmail());
//        User user = userOptional.orElseThrow(() -> new RuntimeException("User details not found for email: " + bookingdto.getEmail()));
//        booking.setUser(user);
//
//        Optional<Showtime> showtimeOptional = showtimeService.getShowtimeById(bookingdto.getShowId());
//        Showtime showtime = showtimeOptional.orElseThrow(() -> new RuntimeException("Showtime details not found for ID: " + bookingdto.getShowId()));
//        booking.setShowtime(showtime);
//
//        // Assign the list of seat IDs to the booking entity
//        booking.setSeatId(bookingdto.getSeatId());
//
//        bookingRepository.save(booking);
//    }

    @Transactional
    @Override
    public Long saveBooking(Bookingdto bookingdto) throws RuntimeException {

//        System.out.println(bookingRepository.existsBookingForSeatInShow(bookingdto.getSeatId(),bookingdto.getShowId()) > 0);

        if (bookingRepository.existsBookingForSeatInShow(bookingdto.getSeatId(), bookingdto.getShowId()) > 0) {
            System.out.println("seat booked");
            throw new RuntimeException("Seat booked");
        }


        Booking booking = new Booking();


        Optional<Showtime> showtimeOptional = showtimeService.getShowtimeById(bookingdto.getShowId());
        if (showtimeOptional.isPresent()) {
            Showtime showtime = showtimeOptional.get();
            booking.setShowtime(showtime);
        } else {
            throw new RuntimeException("Showtime details not found for ID: " + bookingdto.getShowId());
        }
        Optional<User> userOptional = userDetailsService.getByUser(bookingdto.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            booking.setUser(user);
        } else {
            throw new RuntimeException("User details not found for ID: " + bookingdto.getEmail());
        }
        List<SeatReservation> seatReservations = new ArrayList<>();
        bookingdto.getSeatId().forEach(s -> seatReservations.add(new SeatReservation(booking, s)));

        booking.setSeatReservations(seatReservations);
        booking.setTotalAmount(bookingdto.getTotalAmount());
        bookingRepository.save(booking);

//        return bookingRepository.save(booking).toString();
        return booking.getBookingId();
    }


    public Optional<Booking> getBookingById(@PathVariable Long bookingId) {
        return bookingRepository.findAllByBookingId(bookingId);
    }
}
