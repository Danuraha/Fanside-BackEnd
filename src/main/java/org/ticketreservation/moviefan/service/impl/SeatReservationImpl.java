package org.ticketreservation.moviefan.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ticketreservation.moviefan.repository.BookingRepository;
import org.ticketreservation.moviefan.repository.SeatReservationRepository;
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
    public List<Long> getByShowId(Long showId) {
        return bookingRepository.findBookingIdsByShowtimeId(showId);
    }

    public List<Long> getByBookingId(Long bookingId) {
        return seatReservationRepository.findAllByBooking_BookingId(bookingId);
    }

    public List<Long> getSeatIdsByShowId(Long showId) {
        List<Long> bookingIds = bookingRepository.findBookingIdsByShowtimeId(showId);
        List<Long> seatIds = new ArrayList<>();
        for (Long bookingId : bookingIds) {
            List<Long> seatIdsForBooking = seatReservationRepository.findAllByBooking_BookingId(bookingId);
            seatIds.addAll(seatIdsForBooking);
        }
        return seatIds;
    }
    public Map<Long, List<Long>> getSeatIdswithBookingIdsByShowId(Long showId) {

        List<Long> bookingIds = bookingRepository.findBookingIdsByShowtimeId(showId);
        Map<Long, List<Long>> bookingSeatIdsMap = new HashMap<>();
        for (Long bookingId : bookingIds) {
            List<Long> seatIdsForBooking = seatReservationRepository.findAllByBooking_BookingId(bookingId);
            bookingSeatIdsMap.put(bookingId, seatIdsForBooking);
        }
        return bookingSeatIdsMap;
    }

}
