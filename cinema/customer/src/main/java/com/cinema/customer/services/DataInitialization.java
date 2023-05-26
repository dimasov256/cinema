package com.cinema.customer.services;


import com.cinema.customer.domain.*;
import com.cinema.customer.repositories.*;
import com.cinema.clients.customer.model.Layout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.List.of;

@Service
public class DataInitialization {

    @Autowired
    CinemaHallRepository cinemaHallRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    LayoutCapacityRepository layoutCapacityRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        List<CinemaHall> halls = cinemaHallRepository.findAll();
        //TODO add cinema halls type

        if (halls.size() == 0) {

            City odessa = City.builder()
                    .cityName("Odessa")
                    .build();

            City kharkiv = City.builder()
                    .cityName("Kharkov")
                    .build();

            cityRepository.saveAll(of(odessa, kharkiv));

            CinemaHall center_cinema_hall = CinemaHall.builder()
                    .capacities(new ArrayList<>())
                    .name("Center cinema hall")
                    .location("Main hall")
                    .city(odessa)
                    .build();
            center_cinema_hall.setCapacity(LayoutCapacity.builder().capacity(15).layout(Layout.THEATER).build());
            center_cinema_hall.setCapacity(LayoutCapacity.builder().capacity(15).layout(Layout.USHAPE).build());
            cinemaHallRepository.save(center_cinema_hall);

            CinemaHall rodina = CinemaHall.builder()
                    .capacities(new ArrayList<>())
                    .name("Rodina")
                    .location("2nd Floor")
                    .city(odessa)
                    .build();

            rodina.setCapacity(LayoutCapacity.builder().capacity(10).layout(Layout.BOARD).build());
            rodina.setCapacity(LayoutCapacity.builder().capacity(15).layout(Layout.USHAPE).build());
            cinemaHallRepository.save(rodina);

            CinemaHall moskva = CinemaHall.builder()
                    .capacities(new ArrayList<>())
                    .name("Moskva")
                    .location("1st Floor")
                    .city(kharkiv)
                    .build();
            moskva.setCapacity(LayoutCapacity.builder().capacity(15).layout(Layout.THEATER).build());
            moskva.setCapacity(LayoutCapacity.builder().capacity(15).layout(Layout.USHAPE).build());
            cinemaHallRepository.save(moskva);

            User matt = User.builder()
                    .name("matt")
                    .password("secret")
                    .email("matt@email.com")
                    .amountReserved(156.5)
                    .amountAvailable(406.0)
                    .build();
            userRepository.save(matt);

            User diana = User.builder()
                    .name("diana")
                    .password("secret")
                    .email("diana@email.com")
                    .amountReserved(178.0)
                    .amountAvailable(406.0)
                    .build();
            userRepository.save(diana);

            User kristin = User.builder()
                    .name("kristin")
                    .password("secret")
                    .email("kristin@email.com")
                    .amountReserved(9987.0)
                    .amountAvailable(547.0)
                    .build();
            userRepository.save(kristin);


            Film kill_bill = new Film();
            kill_bill.setDate(new java.sql.Date(new java.util.Date().getTime()));
            kill_bill.setStartTime(java.sql.Time.valueOf("11:00:00"));
            kill_bill.setEndTime(java.sql.Time.valueOf("11:30:00"));
            kill_bill.setLayout(Layout.USHAPE);
            kill_bill.setParticipants(8);
            kill_bill.setTitle("Kill Bill");
            kill_bill.setCinemaHall(center_cinema_hall);
            kill_bill.setUser(diana);
            filmRepository.save(kill_bill);

            Film godzilla = new Film();
            godzilla.setDate(new java.sql.Date(new java.util.Date().getTime()));
            godzilla.setStartTime(java.sql.Time.valueOf("13:00:00"));
            godzilla.setEndTime(java.sql.Time.valueOf("14:30:00"));
            godzilla.setLayout(Layout.BOARD);
            godzilla.setParticipants(5);
            godzilla.setTitle("Godzilla");
            godzilla.setCinemaHall(rodina);
            godzilla.setUser(diana);
            filmRepository.save(godzilla);
        }
    }
}
