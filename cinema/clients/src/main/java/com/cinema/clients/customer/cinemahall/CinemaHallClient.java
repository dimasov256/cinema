package com.cinema.clients.customer.cinemahall;

import com.cinema.clients.customer.model.CinemaHallDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "cinemaHall", url = "localhost:8080/api/v1/")
public interface CinemaHallClient {

    @GetMapping("/cinemaHalls/{hallId}")
    CinemaHallDto getCinemaHallById(@PathVariable("hallId") Long hallId);

    @GetMapping("/cinemaHallsLocation/{location}")
    CinemaHallDto getCinemaHallByLocation(@PathVariable("location")String location);

    @PostMapping("/cinemaHalls")
    CinemaHallDto createCinemaHall(@RequestBody CinemaHallDto cinemaHallDto);

    @PutMapping("/cinemaHalls/{hallId}")
    CinemaHallDto updateCinemaHall(@PathVariable("hallId") Long hallId, @RequestBody CinemaHallDto cinemaHallDto);
}
