package com.example.Movie_Ticket_Booking_System.Service;

import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.UserEntryDTO;
import com.example.Movie_Ticket_Booking_System.Models.User;
import com.example.Movie_Ticket_Booking_System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDTO userEntryDTO){

        User user=User.builder()
                .name(userEntryDTO.getName())
                .age(userEntryDTO.getAge())
                .email(userEntryDTO.getEmail())
                .mobile(userEntryDTO.getMobile())
                .build();


        userRepository.save(user);

        return "user entry Created";
    }
}
