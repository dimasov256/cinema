package com.cinema.customer.services;


import com.cinema.customer.domain.CinemaHall;
import com.cinema.customer.domain.Film;
import com.cinema.customer.domain.LayoutCapacity;
import com.cinema.customer.domain.User;
import com.cinema.customer.repositories.CinemaHallRepository;
import com.cinema.customer.repositories.FilmRepository;
import com.cinema.customer.repositories.LayoutCapacityRepository;
import com.cinema.customer.repositories.UserRepository;
import com.cinema.clients.customer.model.Layout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataInitialization {

    @Autowired
    CinemaHallRepository cinemaHallRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    LayoutCapacityRepository layoutCapacityRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        List<CinemaHall> halls = cinemaHallRepository.findAll();
        //TODO add cinema halls type

        if (halls.size() == 0) {
            CinemaHall center_cinema_hall = CinemaHall.builder()
                    .capacities(new ArrayList<>())
                    .name("Center cinema hall")
                    .location("Main hall").build();
            center_cinema_hall.setCapacity(LayoutCapacity.builder().capacity(15).layout(Layout.THEATER).build());
            center_cinema_hall.setCapacity(LayoutCapacity.builder().capacity(15).layout(Layout.USHAPE).build());
            cinemaHallRepository.save(center_cinema_hall);

            CinemaHall rodina = CinemaHall.builder()
                    .capacities(new ArrayList<>())
                    .name("Rodina")
                    .location("2nd Floor").build();
            rodina.setCapacity(LayoutCapacity.builder().capacity(10).layout(Layout.BOARD).build());
            rodina.setCapacity(LayoutCapacity.builder().capacity(15).layout(Layout.USHAPE).build());
            cinemaHallRepository.save(rodina);

            CinemaHall moskva = CinemaHall.builder()
                    .capacities(new ArrayList<>())
                    .name("Moskva")
                    .location("1st Floor").build();
            moskva.setCapacity(LayoutCapacity.builder().capacity(15).layout(Layout.THEATER).build());
            moskva.setCapacity(LayoutCapacity.builder().capacity(15).layout(Layout.USHAPE).build());
            cinemaHallRepository.save(moskva);

            User user = User.builder()
                    .name("matt")
                    .password("secret")
                    .email("some@email.com")
                    .amountReserved(156.5)
                    .amountAvailable(406.0)
                    .build();
            userRepository.save(user);


            Film kill_bill = new Film();
            kill_bill.setDate(new java.sql.Date(new java.util.Date().getTime()));
            kill_bill.setStartTime(java.sql.Time.valueOf("11:00:00"));
            kill_bill.setEndTime(java.sql.Time.valueOf("11:30:00"));
            kill_bill.setLayout(Layout.USHAPE);
            kill_bill.setParticipants(8);
            kill_bill.setTitle("Kill Bill");
            kill_bill.setCinemaHall(center_cinema_hall);
            kill_bill.setUser(user);
            filmRepository.save(kill_bill);

            Film godzilla = new Film();
            godzilla.setDate(new java.sql.Date(new java.util.Date().getTime()));
            godzilla.setStartTime(java.sql.Time.valueOf("13:00:00"));
            godzilla.setEndTime(java.sql.Time.valueOf("14:30:00"));
            godzilla.setLayout(Layout.BOARD);
            godzilla.setParticipants(5);
            godzilla.setTitle("Godzilla");
            godzilla.setCinemaHall(rodina);
            godzilla.setUser(user);
            filmRepository.save(godzilla);
        }
    }
}
