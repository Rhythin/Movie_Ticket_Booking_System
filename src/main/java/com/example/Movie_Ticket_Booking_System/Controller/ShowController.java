package com.example.Movie_Ticket_Booking_System.Controller;

import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.ShowEntryDTO;
import com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs.ShowResponseDTO;
import com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs.ShowSeatResponseDTO;
import com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs.UserResponseDTO;
import com.example.Movie_Ticket_Booking_System.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

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
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CREATED);
        }
    }

    @GetMapping("/get_show_time")
    public ResponseEntity getShowTime(@RequestParam("movieId")int movieId, @RequestParam("theaterId") int theaterId){
        try {
            List<String> response=showService.getShowTime(movieId, theaterId);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById")
    public ResponseEntity getById(@RequestParam("id") int id) {
        try {
            ShowResponseDTO response = showService.getById(id);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll() {
        try {
            List<ShowResponseDTO> response = showService.getAll();
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
        }
    }
}
