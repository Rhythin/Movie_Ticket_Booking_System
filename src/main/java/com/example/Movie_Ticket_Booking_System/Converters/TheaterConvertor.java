package com.example.Movie_Ticket_Booking_System.Converters;

import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.TheaterEntryDTO;
import com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs.TheaterResponseDTO;
import com.example.Movie_Ticket_Booking_System.Models.Theater;
import com.example.Movie_Ticket_Booking_System.Models.TheaterSeat;

import java.util.ArrayList;

public class TheaterConvertor {

    public static Theater ConvertDtoToEntity(TheaterEntryDTO theaterEntryDTO){
        Theater theater=Theater.builder()
                .name(theaterEntryDTO.getName())
                .location(theaterEntryDTO.getLocation())
                .build();

        return theater;
    }

    public static TheaterResponseDTO convertEntityToResponseDTO(Theater theater) {
        TheaterResponseDTO theaterResponseDTO=TheaterResponseDTO.builder()
                .id(theater.getId())
                .name(theater.getName())
                .location(theater.getLocation())
                .theaterSeats(new ArrayList<>())
                .build();

        for(TheaterSeat theaterSeat:theater.getTheaterSeatList()){
            theaterResponseDTO.getTheaterSeats().add(TheaterSeatConvertor.convertEntityToResponseDTO(theaterSeat));
        }

        return theaterResponseDTO;
    }
}
