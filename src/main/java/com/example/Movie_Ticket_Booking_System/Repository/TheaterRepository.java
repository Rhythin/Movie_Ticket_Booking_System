package com.example.Movie_Ticket_Booking_System.Repository;

import com.example.Movie_Ticket_Booking_System.Models.Theater;
import com.example.Movie_Ticket_Booking_System.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {


    public List<Theater> findByLocation(String location);
}
