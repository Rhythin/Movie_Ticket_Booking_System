package com.example.Movie_Ticket_Booking_System.Repository;

import com.example.Movie_Ticket_Booking_System.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {
}
