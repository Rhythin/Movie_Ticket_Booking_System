package com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs;

import com.example.Movie_Ticket_Booking_System.Enums.Genre;
import com.example.Movie_Ticket_Booking_System.Enums.Langauge;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponseDTO {
    private int id;
    private String name;
    private String genre;
    private double rating;
    private int duration;
    private String langauge;

}
