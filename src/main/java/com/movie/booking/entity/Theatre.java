package com.movie.booking.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "theatres")
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Screen> screens;
}
