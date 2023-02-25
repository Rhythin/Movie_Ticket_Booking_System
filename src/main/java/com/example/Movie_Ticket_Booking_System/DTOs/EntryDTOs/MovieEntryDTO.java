package com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs;

import com.example.Movie_Ticket_Booking_System.Enums.Genre;
import com.example.Movie_Ticket_Booking_System.Enums.Langauge;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntryDTO {

    private String name;

    private Genre genre;

    private double rating;

    private int duration;

    private Langauge langauge;

}
