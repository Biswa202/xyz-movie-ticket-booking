package com.movie.booking.util;

import com.movie.booking.entity.Seat;
import com.movie.booking.entity.Show;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

public class BookingContext {

    private final Show show;
    private final List<Seat> seats;
    private final BigDecimal baseAmount;

    public BookingContext(Show show, List<Seat> seats, BigDecimal baseAmount) {
        this.show = show;
        this.seats = seats;
        this.baseAmount = baseAmount;
    }

    public int getSeatCount() {
        return seats.size();
    }

    public BigDecimal getTicketPrice() {
        return show.getPrice();
    }

    public LocalTime getShowTime() {
        return show.getShowTime();
    }

    public BigDecimal getBaseAmount() {
        return baseAmount;
    }
}
