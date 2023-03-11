package com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDTO {
    private int id;
    private String name;
    private String email;
    private int age;
    private String mobile;
}
