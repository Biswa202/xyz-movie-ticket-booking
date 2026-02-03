package com.movie.booking.util;

import java.math.BigDecimal;

public interface DiscountRule {
    boolean applicable(BookingContext context);
    BigDecimal apply(BookingContext context);
}
