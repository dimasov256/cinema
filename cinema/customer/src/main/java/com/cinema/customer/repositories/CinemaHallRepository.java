package com.cinema.customer.repositories;

import com.cinema.clients.customer.model.CinemaHallDto;
import com.cinema.customer.domain.CinemaHall;
import com.cinema.customer.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CinemaHallRepository extends JpaRepository<CinemaHall, Long> {
    CinemaHall findCinemaHallByLocation(String location);

    List<CinemaHall> findCinemaHallByCity(City city);
}
