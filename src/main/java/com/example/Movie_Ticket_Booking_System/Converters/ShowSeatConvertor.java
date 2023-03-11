package com.example.Movie_Ticket_Booking_System.Converters;

import com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs.ShowSeatResponseDTO;
import com.example.Movie_Ticket_Booking_System.Models.ShowSeat;

public class ShowSeatConvertor {

    public static ShowSeatResponseDTO convertEntityToResponseDTO(ShowSeat showSeat) {
        ShowSeatResponseDTO showSeatResponseDTO=ShowSeatResponseDTO.builder()
                .id(showSeat.getId())
                .booked(showSeat.isBooked())
                .price(showSeat.getPrice())
                .seatType(showSeat.getSeatType().toString())
                .bookedOn(showSeat.getBookedOn())
                .build();

        return showSeatResponseDTO;
    }
}
