package com.movie.booking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "bookings")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Show show;

    @ManyToOne
    private Customer customer;

    private BigDecimal totalAmount;

    private String status;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<BookedSeat> bookedSeats;
}
