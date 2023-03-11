package com.example.Movie_Ticket_Booking_System.Service;

import com.example.Movie_Ticket_Booking_System.Converters.ShowConvertor;
import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.ShowEntryDTO;
import com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs.ShowResponseDTO;
import com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs.ShowSeatResponseDTO;
import com.example.Movie_Ticket_Booking_System.Enums.SeatType;
import com.example.Movie_Ticket_Booking_System.Models.*;
import com.example.Movie_Ticket_Booking_System.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
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
        showRepository.save(show);

        Movie movie=movieRepository.findById(showEntryDTO.getMovieId()).get();

        movie.getListOfShows().add(show);
        show.setMovie(movie);

        Theater theater=theaterRepository.findById(showEntryDTO.getTheaterId()).get();

        theater.getListOfShows().add(show);
        show.setTheater(theater);

        movieRepository.save(movie);
        theaterRepository.save(theater);
        //showRepository.save(show);

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

        //showSeatRepository.saveAll(showSeatsList);
        return  showSeatsList;
    }

    public List<String> getShowTime(int movieId, int theaterId) {
        List<String> response=new ArrayList<>();

        List<Show> showList=showRepository.getShowForMovieAndTheater(movieId, theaterId);

        for(Show show:showList){
            String time=show.getShowDate().toString()+" "+show.getShowTime().toString();
            response.add(time);
        }

        return response;
    }


    public ShowResponseDTO getById(int id) {
        Show show=showRepository.findById(id).get();

        ShowResponseDTO showResponseDTO=ShowConvertor.convertEntityToResponseDTO(show);

        return showResponseDTO;
    }

    public List<ShowResponseDTO> getAll() {
        List<ShowResponseDTO> response=new ArrayList<>();

        for(Show show:showRepository.findAll()){
            ShowResponseDTO showResponseDTO=ShowConvertor.convertEntityToResponseDTO(show);
            response.add(showResponseDTO);
        }

        return response;
    }
}
