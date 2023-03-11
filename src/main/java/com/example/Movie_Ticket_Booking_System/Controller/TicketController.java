package com.example.Movie_Ticket_Booking_System.Controller;

import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.TicketEntryDTO;
import com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs.TicketResponseDTO;
import com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs.UserResponseDTO;
import com.example.Movie_Ticket_Booking_System.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/book")
    public ResponseEntity bookTicket(@RequestBody TicketEntryDTO ticketEntryDTO){
        try {
            String response=ticketService.bookTicket(ticketEntryDTO);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/cancel")
    public ResponseEntity bookTicket(@RequestParam int ticketId){
        try {
            String response=ticketService.cancelTicket(ticketId);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/getById")
    public ResponseEntity getById(@RequestParam("id") int id) {
        try {
            TicketResponseDTO response = ticketService.getById(id);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll() {
        try {
            List<TicketResponseDTO> response = ticketService.getAll();
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
        }
    }
}
