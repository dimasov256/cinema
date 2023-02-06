package com.cinema.clients.customer.cinemahall;

import com.cinema.clients.customer.model.CinemaHallDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cinemaHall", url = "localhost:8080/api/v1/")
public interface CinemaHallClient {

    @GetMapping("/cinemaHalls/{hallId}")
    CinemaHallDto getCinemaHallById(@PathVariable("hallId") Long hallId);

    @GetMapping("/cinemaHalls/{location}")
    CinemaHallDto getCinemaHallByLocation(@PathVariable("location")String location);
}
