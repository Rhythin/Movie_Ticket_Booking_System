package com.example.Movie_Ticket_Booking_System.Repository;

import com.example.Movie_Ticket_Booking_System.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
}
