package com.movie.booking.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "screens")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    @OneToMany(mappedBy = "screen")
    private List<Seat> seats;
}
