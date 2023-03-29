package com.cinema.customer.services;


import com.cinema.clients.customer.model.CityDto;
import com.cinema.customer.repositories.CinemaHallRepository;
import com.cinema.customer.web.controller.NotFoundException;
import com.cinema.customer.web.mappers.CinemaHallMapper;
import com.cinema.clients.customer.model.CinemaHallDto;
import com.cinema.customer.web.mappers.CityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CinemaHallService {
    private final CinemaHallRepository cinemaHallRepository;
    private final CinemaHallMapper cinemaHallMapper;

    private final CityMapper cityMapper;

    public List<CinemaHallDto> getAllCinemaHalls() {
        return cinemaHallRepository.findAll().stream()
                .map(cinemaHallMapper::cinemaHallToCinemaHallDto)
                .collect(toList());
    }

    public CinemaHallDto getCinemaHallById(Long hallId) {
        return cinemaHallMapper
                .cinemaHallToCinemaHallDto
                        (cinemaHallRepository.findById(hallId).orElseThrow(() -> new NotFoundException("Not found Hall with ID: " + hallId)));
    }

    public CinemaHallDto createCinemaHall(CinemaHallDto cinemaHallDto) {
        return cinemaHallMapper
                .cinemaHallToCinemaHallDto(
                        cinemaHallRepository.save(
                                cinemaHallMapper.cinemaHallDtoToCinemaHall(cinemaHallDto)));
    }

    public CinemaHallDto updateCinemaHall(Long hallId, CinemaHallDto cinemaHallDto) {

        CinemaHallDto cinemaHallDtoToSave = cinemaHallMapper.cinemaHallToCinemaHallDto(cinemaHallRepository.findById(hallId).orElseThrow(() -> new NotFoundException("Not found Hall with ID: " + hallId)));
        cinemaHallDtoToSave.setCapacities(cinemaHallDto.getCapacities());
        cinemaHallDtoToSave.setLocation(cinemaHallDto.getLocation());
        cinemaHallDtoToSave.setName(cinemaHallDto.getName());
        cinemaHallDtoToSave.setBooked(cinemaHallDto.isBooked());

        return cinemaHallMapper
                .cinemaHallToCinemaHallDto(
                        cinemaHallRepository.save(cinemaHallMapper.cinemaHallDtoToCinemaHall(cinemaHallDtoToSave)));
    }

    public void deleteCinemaHall(Long hallId) {
        cinemaHallRepository.deleteById(hallId);
    }

    public CinemaHallDto getCinemaHallByLocation(String location) {
        return cinemaHallMapper.cinemaHallToCinemaHallDto(cinemaHallRepository.findCinemaHallByLocation(location));
    }

    public List<CinemaHallDto> getCinemaHallsByCity(CityDto cityDto) {
        return cinemaHallRepository.findCinemaHallByCity(cityMapper.cityDtoToCity(cityDto))
                .stream()
                .map(cinemaHallMapper::cinemaHallToCinemaHallDto)
                .collect(toList());
    }
}
