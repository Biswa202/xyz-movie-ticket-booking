package com.movie.booking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "booked_seats")
@Data
public class BookedSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Booking booking;

    @ManyToOne
    private Seat seat;
}
