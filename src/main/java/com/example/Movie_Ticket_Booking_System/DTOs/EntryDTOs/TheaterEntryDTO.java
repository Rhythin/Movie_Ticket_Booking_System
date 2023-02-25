package com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs;

import lombok.Data;

@Data
public class TheaterEntryDTO {

    private String name;
    private String location;

    private int normalSeatCount;
    private int premiumSeatCount;

}
