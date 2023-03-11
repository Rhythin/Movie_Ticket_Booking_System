package com.example.Movie_Ticket_Booking_System.Converters;


import com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs.TheaterSeatDTO;
import com.example.Movie_Ticket_Booking_System.Models.TheaterSeat;

public class TheaterSeatConvertor {

    public static TheaterSeatDTO convertEntityToResponseDTO(TheaterSeat theaterSeat) {
        TheaterSeatDTO theaterSeatDTO=TheaterSeatDTO.builder()
                .id(theaterSeat.getId())
                .seatType(theaterSeat.getSeatType().toString())
                .SeatNo(theaterSeat.getSeatNo())
                .build();

        return theaterSeatDTO;
    }
}
