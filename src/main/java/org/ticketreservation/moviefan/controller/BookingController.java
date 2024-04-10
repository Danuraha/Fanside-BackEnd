package org.ticketreservation.moviefan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.ticketreservation.moviefan.dao.booking.BookingDto;
import org.ticketreservation.moviefan.entities.Booking;
import org.ticketreservation.moviefan.service.BookingService;


import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/booking")
//@PreAuthorize("hasRole('USER')")
@CrossOrigin(origins = "http://localhost:3000")

public class BookingController {

    private final BookingService bookingService;
       @PostMapping("/save")
    public Long saveBooking(@RequestBody BookingDto bookingdto) throws Exception {
       return bookingService.saveBooking(bookingdto);
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

}
