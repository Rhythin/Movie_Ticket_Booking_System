package com.example.Movie_Ticket_Booking_System.Service;

import com.example.Movie_Ticket_Booking_System.Converters.MovieConvertor;
import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.MovieEntryDTO;
import com.example.Movie_Ticket_Booking_System.Models.Movie;
import com.example.Movie_Ticket_Booking_System.Models.Show;
import com.example.Movie_Ticket_Booking_System.Models.Theater;
import com.example.Movie_Ticket_Booking_System.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;


    public String addMovie(MovieEntryDTO movieEntryDTO) {
        Movie movie= MovieConvertor.ConvertDtoToMovieEntity(movieEntryDTO);

        movieRepository.save(movie);

        return "Movie added successfully";
    }

    public String findMovieWithMaxShows() {
        List<Movie> movieList=movieRepository.findAll();

        Movie movieWithMaxShows=null;
        int maxShows=0;

        for(Movie movie:movieList){
            if(movie.getListOfShows().size()>maxShows){
                movieWithMaxShows=movie;
                maxShows=movie.getListOfShows().size();
            }
        }

        if(movieWithMaxShows==null) return "no movie shows found";

        return movieWithMaxShows.getName();
    }

    public List<String> findTheatersForMovie(int movieId) {
        Movie movie=movieRepository.findById(movieId).get();

        List<String> response=new ArrayList<>();

        for(Show show:movie.getListOfShows()){
            response.add(show.getTheater().getName());
        }

        return response;
    }
}
