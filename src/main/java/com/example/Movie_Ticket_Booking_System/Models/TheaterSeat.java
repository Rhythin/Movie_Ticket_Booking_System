package com.example.Movie_Ticket_Booking_System.Models;

import com.example.Movie_Ticket_Booking_System.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "theater_seats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheaterSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private SeatType seatType;

    private String SeatNo;

    @ManyToOne
    @JoinColumn
    private Theater theater;

}
