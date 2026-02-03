package com.movie.booking.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ThirdTicketDiscount implements DiscountRule {

    @Override
    public boolean applicable(BookingContext context) {
        return context.getSeatCount() >= 3;
    }

    @Override
    public BigDecimal apply(BookingContext context) {
        return context.getTicketPrice().multiply(BigDecimal.valueOf(0.5));
    }
}
