package com.example.Movie_Ticket_Booking_System.Converters;

import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.TheaterEntryDTO;
import com.example.Movie_Ticket_Booking_System.Models.Theater;

public class TheaterConvertor {

    public static Theater ConvertDtoToEntity(TheaterEntryDTO theaterEntryDTO){
        Theater theater=Theater.builder()
                .name(theaterEntryDTO.getName())
                .location(theaterEntryDTO.getLocation())
                .build();

        return theater;
    }
}
