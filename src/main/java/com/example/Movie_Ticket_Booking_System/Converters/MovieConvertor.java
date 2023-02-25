package com.example.Movie_Ticket_Booking_System.Converters;

import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.MovieEntryDTO;
import com.example.Movie_Ticket_Booking_System.Models.Movie;

public class MovieConvertor {
    public static Movie ConvertDtoToMovieEntity(MovieEntryDTO movieEntryDTO) {
        Movie movie=Movie.builder()
                .name(movieEntryDTO.getName())
                .genre(movieEntryDTO.getGenre())
                .rating(movieEntryDTO.getRating())
                .duration(movieEntryDTO.getDuration())
                .langauge(movieEntryDTO.getLangauge())
                .build();

        return movie;
    }
}
