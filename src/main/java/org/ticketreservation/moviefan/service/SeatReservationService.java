package org.ticketreservation.moviefan.service;
import java.util.List;
import java.util.Map;

public interface SeatReservationService {
    public List<Long> getByShowId(Long showId);
    public  List<Long> getByBookingId(java.lang.Long bookingId);
    public List<Long> getSeatIdsByShowId(Long showId);
    public Map<Long, List<Long>> getSeatIdswithBookingIdsByShowId(Long showId);


}
