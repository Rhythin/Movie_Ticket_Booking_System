package com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs;

import com.example.Movie_Ticket_Booking_System.Enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowSeatResponseDTO {
    private int id;
    private boolean booked;
    private int price;
    private String seatType;
    private Date bookedOn;

}
