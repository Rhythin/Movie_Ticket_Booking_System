package com.example.Movie_Ticket_Booking_System.Controller;

import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.TheaterEntryDTO;
import com.example.Movie_Ticket_Booking_System.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/add_theater")
    public ResponseEntity addTheater(@RequestBody TheaterEntryDTO theaterEntryDTO){
        String response="";
        try{
            response=theaterService.addTheater(theaterEntryDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Theater not added", HttpStatus.BAD_REQUEST);
        }

    }

}
