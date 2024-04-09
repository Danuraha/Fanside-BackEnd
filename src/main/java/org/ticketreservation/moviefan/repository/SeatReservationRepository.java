package org.ticketreservation.moviefan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.ticketreservation.moviefan.entities.SeatReservation;

import java.util.List;

@Repository
public interface SeatReservationRepository extends JpaRepository<SeatReservation,Long> {
List<SeatReservation> findByBooking_BookingId(Long bookingId);

    @Query("SELECT sr.seatId FROM SeatReservation sr WHERE sr.booking.bookingId = :bookingId")
    List<Long> findAllByBooking_BookingId(@Param("bookingId") Long bookingId);
}
