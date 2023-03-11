package com.example.Movie_Ticket_Booking_System.Controller;

import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.TheaterEntryDTO;
import com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs.TheaterResponseDTO;
import com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs.UserResponseDTO;
import com.example.Movie_Ticket_Booking_System.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/get_unique_locations")
    public ResponseEntity getUniqueLocation(){
        try {
            List<String> response=theaterService.getUniqueLocations();
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById")
    public ResponseEntity getById(@RequestParam("id") int id) {
        try {
            TheaterResponseDTO response = theaterService.getById(id);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll() {
        try {
            List<TheaterResponseDTO> response = theaterService.getAll();
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
        }
    }

}
