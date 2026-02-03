package com.movie.booking.controller;

import com.movie.booking.entity.Show;
import com.movie.booking.repository.ShowRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {

    private final ShowRepository showRepository;

    public TheatreController(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @PostMapping("/{theatreId}/shows")
    public Show createShow(@RequestBody Show show) {
        return showRepository.save(show);
    }

    @DeleteMapping("/shows/{showId}")
    public void deleteShow(@PathVariable Long showId) {
        showRepository.deleteById(showId);
    }
}
