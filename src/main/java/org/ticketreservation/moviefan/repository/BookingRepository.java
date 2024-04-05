package org.ticketreservation.moviefan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ticketreservation.moviefan.entities.Booking;

import java.util.List;
import java.util.Optional;
@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    Optional<Booking> findByBookingId(long bookingId);

    List<Booking> findByShowtimeShowtimeId(long showId);


}
