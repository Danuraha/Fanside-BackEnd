package org.ticketreservation.moviefan.dao.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private String email;
    private List<String> seatId;
    private Long showId;
    private Long totalAmount;
}
