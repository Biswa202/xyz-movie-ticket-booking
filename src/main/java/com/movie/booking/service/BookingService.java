package com.movie.booking.service;

import com.movie.booking.dto.BookRequest;
import com.movie.booking.dto.BookingResponse;
import com.movie.booking.entity.*;
import com.movie.booking.repository.BookingRepository;
import com.movie.booking.repository.CustomerRepository;
import com.movie.booking.repository.SeatRepository;
import com.movie.booking.repository.ShowRepository;
import com.movie.booking.util.BookingContext;
import com.movie.booking.util.DiscountRule;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookingService {

    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;
    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final List<DiscountRule> discountRules;

    public BookingService(
            ShowRepository showRepository,
            SeatRepository seatRepository,
            BookingRepository bookingRepository,
            CustomerRepository customerRepository,
            List<DiscountRule> discountRules) {
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.discountRules = discountRules;
    }

    @Transactional
    public BookingResponse bookTickets(BookRequest request) {

        Show show = showRepository.findById(request.getShowId())
                .orElseThrow(() -> new IllegalArgumentException("Show not found"));

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        // Lock seats to avoid double booking
        List<Seat> seats = seatRepository.lockSeats(request.getSeatIds());

        if (seats.size() != request.getSeatIds().size()) {
            throw new IllegalStateException("Some seats are not available");
        }

        BigDecimal baseAmount =
                show.getPrice().multiply(BigDecimal.valueOf(seats.size()));

        BookingContext context = new BookingContext(show, seats, baseAmount);

        BigDecimal discount = BigDecimal.ZERO;
        for (DiscountRule rule : discountRules) {
            if (rule.applicable(context)) {
                discount = discount.add(rule.apply(context));
            }
        }

        BigDecimal finalAmount = baseAmount.subtract(discount);

        Booking booking = new Booking();
        booking.setShow(show);
        booking.setCustomer(customer);
        booking.setStatus("CONFIRMED");
        booking.setTotalAmount(finalAmount);

        List<BookedSeat> bookedSeats = seats.stream()
                .map(seat -> {
                    BookedSeat bs = new BookedSeat();
                    bs.setSeat(seat);
                    bs.setBooking(booking);
                    return bs;
                })
                .toList();

        booking.setBookedSeats(bookedSeats);

        bookingRepository.save(booking);

        return new BookingResponse(booking.getId(), finalAmount);
    }
}
