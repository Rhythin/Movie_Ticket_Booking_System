package com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntryDTO {

    private int id;

    private String name;

    private int age;

    private String email;

    private String mobile;
}
