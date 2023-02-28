package com.example.Movie_Ticket_Booking_System.Converters;

import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.TicketEntryDTO;
import com.example.Movie_Ticket_Booking_System.Models.Ticket;

public class TicketConvertor {

    public static Ticket convertDtoToTicketEntity(TicketEntryDTO ticketEntryDTO){
        Ticket ticket=Ticket.builder()

                .build();

        return ticket;
    }
}
