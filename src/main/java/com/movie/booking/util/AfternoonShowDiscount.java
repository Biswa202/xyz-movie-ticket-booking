package com.movie.booking.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AfternoonShowDiscount implements DiscountRule {

    @Override
    public boolean applicable(BookingContext context) {
        int hour = context.getShowTime().getHour();
        return hour >= 12 && hour <= 16;
    }

    @Override
    public BigDecimal apply(BookingContext context) {
        return context.getBaseAmount().multiply(BigDecimal.valueOf(0.20));
    }
}
