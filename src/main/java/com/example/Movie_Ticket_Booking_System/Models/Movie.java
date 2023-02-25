package com.example.Movie_Ticket_Booking_System.Models;

import com.example.Movie_Ticket_Booking_System.Enums.Genre;
import com.example.Movie_Ticket_Booking_System.Enums.Langauge;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private double rating;

    private int duration;

    @Enumerated(value = EnumType.STRING)
    private Langauge langauge;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Show> listOfShows=new ArrayList<>();


}
