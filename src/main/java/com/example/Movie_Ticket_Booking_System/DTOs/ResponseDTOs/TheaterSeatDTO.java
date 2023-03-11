package com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs;

import com.example.Movie_Ticket_Booking_System.Enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TheaterSeatDTO {
    private int id;
    private String seatType;
    private String SeatNo;
}
