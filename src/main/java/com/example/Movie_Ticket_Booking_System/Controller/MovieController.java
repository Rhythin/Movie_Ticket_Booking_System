package com.example.Movie_Ticket_Booking_System.Controller;

import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.MovieEntryDTO;
import com.example.Movie_Ticket_Booking_System.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity addMovie(@RequestBody MovieEntryDTO movieEntryDTO){
        try {
            String response=movieService.addMovie(movieEntryDTO) ;
            return new ResponseEntity(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/movie_with_max_shows")
    public ResponseEntity findMovieWithMaxShows(){
        try {
            String response=movieService.findMovieWithMaxShows();
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error occured", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/theaters_for_movie/{id}")
    public ResponseEntity findTheatersForMovie(@PathVariable("id") int id){
        try {
            List<String> response;
            response = movieService.findTheatersForMovie(id);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
