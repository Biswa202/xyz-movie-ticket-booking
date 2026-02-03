package com.movie.booking.dto;


import lombok.Data;

import java.util.List;

@Data
public class BookRequest {
    private Long showId;
    private Long customerId;
    private List<Long> seatIds;
}
