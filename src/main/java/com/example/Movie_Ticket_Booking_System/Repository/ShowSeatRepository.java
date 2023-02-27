package com.example.Movie_Ticket_Booking_System.Repository;

import com.example.Movie_Ticket_Booking_System.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {
}
