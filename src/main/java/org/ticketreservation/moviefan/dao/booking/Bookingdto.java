package org.ticketreservation.moviefan.dao.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bookingdto {
    private Long userId;
    private String seatId;
    private Long showId;
}
