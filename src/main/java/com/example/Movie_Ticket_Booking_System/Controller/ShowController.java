package com.example.Movie_Ticket_Booking_System.Controller;

import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.ShowEntryDTO;
import com.example.Movie_Ticket_Booking_System.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    ShowService showService;


    @PostMapping("/add_show")
    public ResponseEntity addShow(@RequestBody ShowEntryDTO showEntryDTO){
        try {
            String response=showService.addShow(showEntryDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Show not added", HttpStatus.CREATED);
        }
    }
}