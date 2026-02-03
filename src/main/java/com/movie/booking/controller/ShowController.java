package com.movie.booking.controller;

import com.movie.booking.entity.Show;
import com.movie.booking.repository.ShowRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    private final ShowRepository showRepository;

    public ShowController(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @GetMapping
    public List<Show> browseShows(
            @RequestParam Long movieId,
            @RequestParam String city,
            @RequestParam LocalDate date) {

        return showRepository.findShows(movieId, city, date);
    }
}
