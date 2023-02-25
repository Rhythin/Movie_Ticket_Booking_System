package com.example.Movie_Ticket_Booking_System.Converters;

import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.UserEntryDTO;
import com.example.Movie_Ticket_Booking_System.Models.User;

public class UserConvertor {

    public static User ConvertDtoToUserEntity(UserEntryDTO userEntryDTO){
        User user=User.builder()
                .name(userEntryDTO.getName())
                .age(userEntryDTO.getAge())
                .email(userEntryDTO.getEmail())
                .mobile(userEntryDTO.getMobile())
                .build();
        return user;
    }

}
