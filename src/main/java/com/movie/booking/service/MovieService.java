package com.movie.booking.service;

import com.movie.booking.entity.Theatre;
import com.movie.booking.repository.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final TheatreRepository theatreRepository;

    public MovieService(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    public List<Theatre> getTheatres(String city, String movieName) {
        return theatreRepository.findByCityAndMovieName(city, movieName);
    }
}