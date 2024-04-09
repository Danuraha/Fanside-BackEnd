package org.ticketreservation.moviefan.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ticketreservation.moviefan.entities.Cinema;
import org.ticketreservation.moviefan.entities.SeatReservation;
import org.ticketreservation.moviefan.repository.BookingRepository;
import org.ticketreservation.moviefan.repository.SeatReservationRepository;
import org.ticketreservation.moviefan.service.BookingService;
import org.ticketreservation.moviefan.service.SeatReservationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class SeatReservationImpl implements SeatReservationService {
    private final SeatReservationRepository seatReservationRepository;
    private final BookingRepository bookingRepository;
//    public List<SeatReservation> getSeatReservation(Long bookingId){
//        if(null!=bookingId){
//            return seatReservationRepository.findByBooking_BookingId(bookingId);
//        }
//        else {
//            return seatReservationRepository.findAll();
//        }
//    }

    public List<Long> getByShowId(Long showId) {

        return bookingRepository.findBookingIdsByShowtimeId(showId);
    }

    public List<Long> getByBookingId(Long bookingId) {

        return seatReservationRepository.findAllByBooking_BookingId(bookingId);
    }

    public List<Long> getSeatIdsByShowId(Long showId) {
        // Get filtered booking IDs by show ID
        List<Long> bookingIds = bookingRepository.findBookingIdsByShowtimeId(showId);

        // Initialize list to store seat IDs
        List<Long> seatIds = new ArrayList<>();

        // Iterate through each booking ID and fetch corresponding seat IDs
        for (Long bookingId : bookingIds) {
            List<Long> seatIdsForBooking = seatReservationRepository.findAllByBooking_BookingId(bookingId);
            seatIds.addAll(seatIdsForBooking);
        }

        return seatIds;
    }

    public Map<Long, List<Long>> getSeatIdswithBookingIdsByShowId(Long showId) {
        // Get filtered booking IDs by show ID
        List<Long> bookingIds = bookingRepository.findBookingIdsByShowtimeId(showId);

        // Initialize map to store booking ID as key and seat IDs as values
        Map<Long, List<Long>> bookingSeatIdsMap = new HashMap<>();

        // Iterate through each booking ID and fetch corresponding seat IDs
        for (Long bookingId : bookingIds) {
            List<Long> seatIdsForBooking = seatReservationRepository.findAllByBooking_BookingId(bookingId);
            bookingSeatIdsMap.put(bookingId, seatIdsForBooking);
        }

        return bookingSeatIdsMap;
    }

}
