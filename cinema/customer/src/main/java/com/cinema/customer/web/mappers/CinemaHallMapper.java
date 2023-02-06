package com.cinema.customer.web.mappers;


import com.cinema.customer.domain.CinemaHall;
import com.cinema.clients.customer.model.CinemaHallDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper
@DecoratedWith(CinemaHallMapperDecorator.class)
public interface CinemaHallMapper {

    CinemaHallDto cinemaHallToCinemaHallDto(CinemaHall cinemaHall);

    CinemaHall cinemaHallDtoToCinemaHall(CinemaHallDto cinemaHallDto);
}
