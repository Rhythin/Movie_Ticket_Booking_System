package com.example.Movie_Ticket_Booking_System.Service;

import com.example.Movie_Ticket_Booking_System.Converters.TheaterConvertor;
import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.TheaterEntryDTO;
import com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs.TheaterResponseDTO;
import com.example.Movie_Ticket_Booking_System.Enums.SeatType;
import com.example.Movie_Ticket_Booking_System.Models.Theater;
import com.example.Movie_Ticket_Booking_System.Models.TheaterSeat;
import com.example.Movie_Ticket_Booking_System.Repository.TheaterRepository;
import com.example.Movie_Ticket_Booking_System.Repository.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TheaterService {
    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    public String addTheater(TheaterEntryDTO theaterEntryDTO){

        Theater theater= TheaterConvertor.ConvertDtoToEntity(theaterEntryDTO);

        List<TheaterSeat> theaterSeatList=crateTheaterSeats(theaterEntryDTO, theater);

        theater.setTheaterSeatList(theaterSeatList);

        theaterRepository.save(theater);

        return "Theater and theater Seats created";
    }

    private List<TheaterSeat> crateTheaterSeats(TheaterEntryDTO theaterEntryDTO, Theater theater) {

        int normalSeatCount=theaterEntryDTO.getNormalSeatCount();
        int premiumSeatCount=theaterEntryDTO.getPremiumSeatCount();

        List<TheaterSeat> theaterSeatList=new ArrayList<>();

        //creating normal seats
        for(int i=1;i<=normalSeatCount;i++){
            TheaterSeat theaterSeat=TheaterSeat.builder()
                    .SeatNo(i+"N")
                    .seatType(SeatType.normal)
                    .theater(theater)
                    .build();

            theaterSeatList.add(theaterSeat);
        }
        //crating premium seats
        for(int i=1;i<=premiumSeatCount;i++){
            TheaterSeat theaterSeat=TheaterSeat.builder()
                    .SeatNo(i+"P")
                    .seatType(SeatType.premium)
                    .theater(theater)
                    .build();

            theaterSeatList.add(theaterSeat);
        }

//        theaterSeatRepository.saveAll(theaterSeatList);

        return theaterSeatList;
    }

    public List<String> getUniqueLocations() {
        Set<String> response=new HashSet<>();

        List<Theater> theaterList=theaterRepository.findAll();

        for (Theater theater:theaterList){
            response.add(theater.getLocation());
        }

        return new ArrayList<>(response);
    }

    public TheaterResponseDTO getById(int id) {
        Theater theater=theaterRepository.findById(id).get();
        TheaterResponseDTO theaterResponseDTO=TheaterConvertor.convertEntityToResponseDTO(theater);

        return theaterResponseDTO;
    }

    public List<TheaterResponseDTO> getAll() {
        List<TheaterResponseDTO> responseDTOList=new ArrayList<>();

        for(Theater theater:theaterRepository.findAll()){
            responseDTOList.add(TheaterConvertor.convertEntityToResponseDTO(theater));
        }

        return responseDTOList;
    }


}
