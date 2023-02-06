package com.cinema.customer.web.mappers;

import com.cinema.customer.domain.CinemaHall;
import com.cinema.clients.customer.model.CinemaHallDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CinemaHallMapperDecorator implements CinemaHallMapper {

    private CinemaHallMapper cinemaHallMapper;

    @Autowired
    public void setCinemaHallMapper(CinemaHallMapper cinemaHallMapper) {
        this.cinemaHallMapper = cinemaHallMapper;
    }

    @Override
    public CinemaHallDto cinemaHallToCinemaHallDto(CinemaHall cinemaHall) {
        return cinemaHallMapper.cinemaHallToCinemaHallDto(cinemaHall);
    }

    @Override
    public CinemaHall cinemaHallDtoToCinemaHall(CinemaHallDto cinemaHallDto) {
        return cinemaHallMapper.cinemaHallDtoToCinemaHall(cinemaHallDto);
    }
}
