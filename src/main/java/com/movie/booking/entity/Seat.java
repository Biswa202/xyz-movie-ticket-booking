package com.movie.booking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;
    private String type;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;
}
