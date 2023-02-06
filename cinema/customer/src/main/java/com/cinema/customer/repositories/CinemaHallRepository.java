package com.cinema.customer.repositories;

import com.cinema.clients.customer.model.CinemaHallDto;
import com.cinema.customer.domain.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaHallRepository extends JpaRepository<CinemaHall, Long> {
    CinemaHallDto findCinemaHallByLocation(String location);
}
