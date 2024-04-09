package org.ticketreservation.moviefan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.ticketreservation.moviefan.entities.Booking;

import java.util.List;
import java.util.Optional;
@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    @Query("select count(*) from Booking b join b.seatReservations sr where sr.seatId in ?1 and  b.showtime.showtimeId=?2")
    int existsBookingForSeatInShow(List<String> seatId,Long showId);

    Optional<Booking> findAllByBookingId(long bookingId);

//    List<Booking> findByShowtimeShowtimeId(long showId);



    @Query("SELECT b.bookingId FROM Booking b WHERE b.showtime.showtimeId = :showId")
    List<Long> findBookingIdsByShowtimeId(@Param("showId") Long showId);

//    @Query("SELECT DISTINCT b FROM Booking b " +
//            "LEFT JOIN FETCH b.seatReservations sr " +
//            "WHERE b.showtime.showtimeId = :showId")
//    List<Booking> findByShowtimeShowtimeIdWithSeatReservations(long showId);



}
