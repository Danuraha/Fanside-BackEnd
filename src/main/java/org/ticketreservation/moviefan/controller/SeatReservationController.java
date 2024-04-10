package org.ticketreservation.moviefan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.ticketreservation.moviefan.service.SeatReservationService;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/reservation")
public class SeatReservationController {
    private final SeatReservationService seatReservationService;
    @GetMapping("/getshow/{showId}")
    public List<Long> getByShowId(@PathVariable Long showId){
        return seatReservationService.getByShowId(showId);
    }
    @GetMapping("/getseat/{bookingId}")
    public List<Long> getByBookingId(@PathVariable Long bookingId){
        return seatReservationService.getByBookingId(bookingId);
    }
    @GetMapping("/seatIds/{showId}")
    public List<Long> getSeatIdsByShowId(@PathVariable Long showId) {
        return seatReservationService.getSeatIdsByShowId(showId);
    }
    @GetMapping("/seatIdswithbookingId/{showId}")
    public Map<Long, List<Long>> getSeatIdswithBookingIdsByShowId(@PathVariable Long showId) {
        return seatReservationService.getSeatIdswithBookingIdsByShowId(showId);
    }
}
