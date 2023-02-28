package com.example.Movie_Ticket_Booking_System.Repository;

import com.example.Movie_Ticket_Booking_System.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {

    @Query(value = "select * from shows s where s.movie_id=:movieId and s.theater_id=:theaterId"
            , nativeQuery = true)
    List<Show> getShowForMovieAndTheater(int movieId, int theaterId);
}
