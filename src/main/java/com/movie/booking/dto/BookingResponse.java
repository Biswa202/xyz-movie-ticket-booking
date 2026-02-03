package com.movie.booking.dto;

import java.math.BigDecimal;

public class BookingResponse {
    private Long bookingId;
    private BigDecimal amount;

    public BookingResponse(Long bookingId, BigDecimal amount) {
        this.bookingId = bookingId;
        this.amount = amount;
    }
}
