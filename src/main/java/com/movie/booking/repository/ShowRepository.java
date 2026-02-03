package com.movie.booking.repository;

import com.movie.booking.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {

    @Query("""
        select s from Show s
        where s.movie.id = :movieId
        and s.screen.theatre.city = :city
        and s.showDate = :date
    """)
    List<Show> findShows(Long movieId, String city, LocalDate date);
}
