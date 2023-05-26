package com.cinema.customer.web.controller;


import com.cinema.clients.customer.model.CityDto;
import com.cinema.customer.domain.CinemaHall;
import com.cinema.customer.domain.City;
import com.cinema.customer.services.CinemaHallService;
import com.cinema.clients.customer.model.CinemaHallDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class CinemaHallController {

    private final CinemaHallService cinemaHallService;

    @GetMapping("/cinemaHalls")
    public ResponseEntity<List<CinemaHallDto>> getAllCinemaHalls(@CookieValue(value = "token", defaultValue = "empty") String token) {
        System.out.println("Cookies: " + token);
        return new ResponseEntity<>(cinemaHallService.getAllCinemaHalls(), HttpStatus.OK);
    }

    @GetMapping("/cinemaHalls/{hallId}")
    public ResponseEntity<CinemaHallDto> getCinemaHallById(@PathVariable("hallId") Long hallId) {
        return new ResponseEntity<>(cinemaHallService.getCinemaHallById(hallId), HttpStatus.OK);
    }

    @GetMapping("/cinemaHallsLocation/{location}")
    public ResponseEntity<CinemaHallDto> getCinemaHallByLocation(@PathVariable("location")String location) {
        return new ResponseEntity<>(cinemaHallService.getCinemaHallByLocation(location), HttpStatus.OK);
    }

    @PostMapping("/cinemaHalls")
    public ResponseEntity<CinemaHallDto> createCinemaHall(@RequestBody CinemaHallDto cinemaHallDto) {
        return new ResponseEntity<>(cinemaHallService.createCinemaHall(cinemaHallDto), HttpStatus.CREATED);
    }

    @PutMapping("/cinemaHalls/{hallId}")
    public ResponseEntity<CinemaHallDto> updateCinemaHall(@PathVariable("hallId") Long hallId,
                                                          @RequestBody CinemaHallDto cinemaHallDto) {
        return new ResponseEntity<>(cinemaHallService.updateCinemaHall(hallId, cinemaHallDto), HttpStatus.OK);
    }

    @DeleteMapping("/cinemaHalls/{hallId}")
    public void deleteCinemaHall(@PathVariable("hallId") Long hallId) {
        cinemaHallService.deleteCinemaHall(hallId);
    }

    @GetMapping("/cinemaHalls/city/{name}")
    public ResponseEntity<List<CinemaHallDto>> getCinemaHallsByCity(@PathVariable("name")String name ) {
        return new ResponseEntity<>(cinemaHallService.getCinemaHallsByCity(name), HttpStatus.OK);
    }
}
