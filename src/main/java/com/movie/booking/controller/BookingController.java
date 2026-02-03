package com.movie.booking.controller;

import com.movie.booking.dto.BookRequest;
import com.movie.booking.dto.BookingResponse;
import com.movie.booking.service.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public BookingResponse book(@RequestBody BookRequest request) {
        return bookingService.bookTickets(request);
    }
}
