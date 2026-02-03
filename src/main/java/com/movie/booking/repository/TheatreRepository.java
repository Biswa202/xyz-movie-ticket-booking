package com.movie.booking.repository;

import com.movie.booking.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    List<Theatre> findByCityAndMovieName(String city, String movieName);
}
