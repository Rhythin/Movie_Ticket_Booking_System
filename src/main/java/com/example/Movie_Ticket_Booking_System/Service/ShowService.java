package com.example.Movie_Ticket_Booking_System.Service;

import com.example.Movie_Ticket_Booking_System.Converters.ShowConvertor;
import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.ShowEntryDTO;
import com.example.Movie_Ticket_Booking_System.Enums.SeatType;
import com.example.Movie_Ticket_Booking_System.Models.*;
import com.example.Movie_Ticket_Booking_System.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    public String addShow(ShowEntryDTO showEntryDTO){

        Show show= ShowConvertor.convertDtotoShow(showEntryDTO);

        List<ShowSeat> showSeatsList=createShowSeatsList(showEntryDTO, show);

        show.setListOfShowSeats(showSeatsList);

        Movie movie=movieRepository.findById(showEntryDTO.getMovieId()).get();

        movie.getListOfShows().add(show);
        show.setMovie(movie);

        Theater theater=theaterRepository.findById(showEntryDTO.getTheaterId()).get();

        theater.getListOfShows().add(show);
        show.setTheater(theater);

        movieRepository.save(movie);
        theaterRepository.save(theater);
        showRepository.save(show);

        return "show has been created";
    }

    private List<ShowSeat> createShowSeatsList(ShowEntryDTO showEntryDTO, Show show) {
        List<ShowSeat> showSeatsList=new ArrayList<>();

        int normalSeatPrice=showEntryDTO.getNormalSeatPrice();
        int premiumSeatPrice=showEntryDTO.getPremiumSeatPrice();

        Theater theater=theaterRepository.findById(showEntryDTO.getTheaterId()).get();
        List<TheaterSeat> theaterSeatList=theater.getTheaterSeatList();

        for(TheaterSeat theaterSeat:theaterSeatList){
            ShowSeat showSeats= ShowSeat.builder()
                    .seatNo(theaterSeat.getSeatNo())
                    .seatType(theaterSeat.getSeatType())
                    .show(show)
                    .price(theaterSeat.getSeatType()== SeatType.normal?normalSeatPrice:premiumSeatPrice)
                    .build();

            showSeatsList.add(showSeats);
        }

        showSeatRepository.saveAll(showSeatsList);
        return  showSeatsList;
    }

    public String getShowTime(int movieId, int theaterId) {
        return LocalDate.now().toString();
    }
}
