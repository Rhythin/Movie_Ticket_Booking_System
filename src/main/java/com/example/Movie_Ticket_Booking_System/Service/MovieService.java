package com.example.Movie_Ticket_Booking_System.Service;

import com.example.Movie_Ticket_Booking_System.Converters.MovieConvertor;
import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.MovieEntryDTO;
import com.example.Movie_Ticket_Booking_System.Models.Movie;
import com.example.Movie_Ticket_Booking_System.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;


    public String addMovie(MovieEntryDTO movieEntryDTO) {
        Movie movie= MovieConvertor.ConvertDtoToMovieEntity(movieEntryDTO);

        movieRepository.save(movie);

        return "Movie added successfully";
    }
}
