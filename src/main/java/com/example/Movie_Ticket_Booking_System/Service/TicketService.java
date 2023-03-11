package com.example.Movie_Ticket_Booking_System.Service;

import com.example.Movie_Ticket_Booking_System.Converters.TicketConvertor;
import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.TicketEntryDTO;
import com.example.Movie_Ticket_Booking_System.Models.Show;
import com.example.Movie_Ticket_Booking_System.Models.ShowSeat;
import com.example.Movie_Ticket_Booking_System.Models.Ticket;
import com.example.Movie_Ticket_Booking_System.Models.User;
import com.example.Movie_Ticket_Booking_System.Repository.ShowRepository;
import com.example.Movie_Ticket_Booking_System.Repository.ShowSeatRepository;
import com.example.Movie_Ticket_Booking_System.Repository.TicketRepository;
import com.example.Movie_Ticket_Booking_System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;



    public String bookTicket(TicketEntryDTO ticketEntryDTO) throws Exception {

        if(!validateRequestedSeats(ticketEntryDTO)){
            throw new Exception("requested tickets not valid not available/already booked");
        }

        Ticket ticket= TicketConvertor.convertDtoToTicketEntity(ticketEntryDTO);
        ticketRepository.save(ticket);

        int total=0;
        List<Integer> bookingSeatsIds=ticketEntryDTO.getRequestedSeats();
        for(Integer showSeatID:bookingSeatsIds){
            ShowSeat showSeat=showSeatRepository.findById(showSeatID).get();

            total+=showSeat.getPrice();
            showSeat.setTicket(ticket);
            showSeat.setBooked(true);
            showSeat.setBookedOn(new Date());
            ticket.getBookedSeatList().add(showSeat);
            showSeatRepository.save(showSeat);
        }

        ticket.setTotalAmount(total);

        Show show=showRepository.findById(ticketEntryDTO.getShowId()).get();
        ticket.setShow(show);
        ticket.setShowDate(show.getShowDate());
        ticket.setShowTime(show.getShowTime());
        ticket.setMovieName(show.getMovie().getName());
        ticket.setTheaterName(show.getTheater().getName());

        show.getListOfTickets().add(ticket);

        User user=userRepository.findById(ticketEntryDTO.getUserId()).get();

        ticket.setUser(user);
        user.getListOfTickets().add(ticket);

        userRepository.save(user);
        showRepository.save(show);

        return "ticket booked successfully. Ticket Id:"+ticket.getId();
    }

    public boolean validateRequestedSeats(TicketEntryDTO ticketEntryDTO){

        List<Integer> requestedSeats=ticketEntryDTO.getRequestedSeats();

        for(Integer showSeatId:requestedSeats){
                ShowSeat showSeat = showSeatRepository.findById(showSeatId).get();
                if(showSeat.isBooked()){
                    return false;
                }
        }

        return true;
    }

    public String cancelTicket(int ticketId) {

        Ticket ticket=ticketRepository.findById(ticketId).get();

        for (ShowSeat showSeat:ticket.getBookedSeatList()){
            showSeat.setBooked(false);
            showSeat.setBookedOn(null);
            showSeat.setTicket(null);
            showSeatRepository.save(showSeat);
        }

        ticket.setCancelled(true);
        ticket.getBookedSeatList().clear();

        ticketRepository.save(ticket);

        return "ticket cancelled";
    }
}
