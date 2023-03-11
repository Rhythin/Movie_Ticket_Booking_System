package com.example.Movie_Ticket_Booking_System.Service;

import com.example.Movie_Ticket_Booking_System.Converters.TicketConvertor;
import com.example.Movie_Ticket_Booking_System.Converters.UserConvertor;
import com.example.Movie_Ticket_Booking_System.DTOs.EntryDTOs.UserEntryDTO;

import com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs.TicketResponseDTO;
import com.example.Movie_Ticket_Booking_System.DTOs.ResponseDTOs.UserResponseDTO;
import com.example.Movie_Ticket_Booking_System.Models.Ticket;
import com.example.Movie_Ticket_Booking_System.Models.User;
import com.example.Movie_Ticket_Booking_System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TicketService ticketService;

    public String addUser(UserEntryDTO userEntryDTO){

        User user= UserConvertor.ConvertDtoToUserEntity(userEntryDTO);

        userRepository.save(user);

        return "user entry Created userId is :"+user.getId();
    }

    public UserResponseDTO getById(int id) {
       User user=userRepository.findById(id).get();

        return UserConvertor.convertToUserResponseDTO(user);
    }


    public List<UserResponseDTO> getAll() {
        List<User> userList=userRepository.findAll();

        List<UserResponseDTO> responseDTOList=new ArrayList<>();
        for(User user:userList){
            UserResponseDTO userResponseDTO=UserConvertor.convertToUserResponseDTO(user);
            responseDTOList.add(userResponseDTO);
        }

        return responseDTOList;
    }

    public String updateUser(UserEntryDTO userEntryDTO, int id) {
        User user=userRepository.findById(id).get();

        user.setAge(userEntryDTO.getAge());
        user.setName(userEntryDTO.getName());
        user.setEmail(userEntryDTO.getEmail());
        user.setMobile(userEntryDTO.getMobile());

        userRepository.save(user);

        return "Details of user with id "+id+" is Updated";
    }


    public void deleteById(int id) {
        User user=userRepository.findById(id).get();

        //cancel all tickets for the user
        for(Ticket ticket:user.getListOfTickets()){
            ticketService.cancelTicket(ticket.getId());
        }

        userRepository.delete(user);
        //cascade takes care of users
    }

    public List<TicketResponseDTO> getTicketsById(int id) {
        User user=userRepository.findById(id).get();
        List<Ticket> ticketList=user.getListOfTickets();

        List<TicketResponseDTO> responseDTOS=new ArrayList<>();

        for(Ticket ticket:ticketList){
            TicketResponseDTO ticketResponseDTO= TicketConvertor.convertEntityToResponseDTO(ticket);
            responseDTOS.add(ticketResponseDTO);
        }

        return responseDTOS;
    }
}
