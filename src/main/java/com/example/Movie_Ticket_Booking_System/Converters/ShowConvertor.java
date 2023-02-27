package com.example.Movie_Ticket_Booking_System.Converters;

import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.ShowEntryDTO;
import com.example.Movie_Ticket_Booking_System.Models.Show;

public class ShowConvertor {

    public static Show convertDtotoShow(ShowEntryDTO showEntryDTO){
        Show show=Show.builder()
                .showDate(showEntryDTO.getShowDate())
                .showTime(showEntryDTO.getShowTime())
                .showType(showEntryDTO.getShowType())
                .build();

        return show;
    }
}
