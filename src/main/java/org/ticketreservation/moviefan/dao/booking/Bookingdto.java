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
    private String email;
    private String seatId;
    private Long showId;
}
