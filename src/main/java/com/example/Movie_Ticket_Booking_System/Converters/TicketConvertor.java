package com.example.Movie_Ticket_Booking_System.Converters;

import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.TicketEntryDTO;
import com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs.TicketResponseDTO;
import com.example.Movie_Ticket_Booking_System.Models.ShowSeat;
import com.example.Movie_Ticket_Booking_System.Models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketConvertor {

    public static Ticket convertDtoToTicketEntity(TicketEntryDTO ticketEntryDTO){
        Ticket ticket=new Ticket();

        return ticket;
    }

    public static TicketResponseDTO convertEntityToResponseDTO(Ticket ticket) {
        TicketResponseDTO ticketResponseDTO=TicketResponseDTO.builder()
                .id(ticket.getId())
                .movieName(ticket.getMovieName())
                .theaterName(ticket.getTheaterName())
                .showDate(ticket.getShowDate())
                .showTime(ticket.getShowTime())
                .totalAmount(ticket.getTotalAmount())
                .cancelled(ticket.isCancelled())
                .ticketId(ticket.getTicketId())
                .build();

        List<String> bookedSeats=new ArrayList<>();
        for(ShowSeat showSeat:ticket.getBookedSeatList()){
            bookedSeats.add(showSeat.getSeatNo());
        }
        ticketResponseDTO.setBookedSeats(bookedSeats);


        return ticketResponseDTO;
    }
}
