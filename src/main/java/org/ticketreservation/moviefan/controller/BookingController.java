package org.ticketreservation.moviefan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ticketreservation.moviefan.dao.booking.Bookingdto;
import org.ticketreservation.moviefan.entities.Booking;
import org.ticketreservation.moviefan.service.BookingService;


import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/booking")
@CrossOrigin(origins = "http://localhost:3000")

public class BookingController {

    private final BookingService bookingService;

//    @PostMapping("/save")
//    public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking){
//       Optional<User> user= userDetailsService.getByUser(booking.getBookingId());
//       booking.setUser(user.get());
//
//       Optional<Showtime> showtime=showtimeService.getShowtimeById(booking.getBookingId());
//       booking.setShowtime(showtime.get());
//
//        bookingService.saveBooking(booking);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

    @PostMapping("/save")
    public Long saveBooking(@RequestBody Bookingdto bookingdto) throws Exception {
       return bookingService.saveBooking(bookingdto);
//        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{bookingId}")
    public ResponseEntity<Optional<Booking>> getBookingById(@PathVariable Long bookingId) {
        Optional<Booking> booking = bookingService.getBookingById(bookingId);
        if (booking.isPresent()) {
            return ResponseEntity.ok(booking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//
//@GetMapping("/{showId}")
//public List<Long> getByShowId(@PathVariable Long showId){
//    return bookingService.getByShowId(showId);
//}


}
