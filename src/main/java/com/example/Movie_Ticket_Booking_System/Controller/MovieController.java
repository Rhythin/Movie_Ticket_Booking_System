package com.example.Movie_Ticket_Booking_System.Controller;

import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.MovieEntryDTO;
import com.example.Movie_Ticket_Booking_System.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PutMapping("/addMovie")
    public ResponseEntity addMovie(@RequestBody MovieEntryDTO movieEntryDTO){
        try {
            String response=movieService.addMovie(movieEntryDTO) ;
            return new ResponseEntity(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }
    }
}
