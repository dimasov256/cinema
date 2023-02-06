package com.cinema.customer.web.mappers;


import com.cinema.customer.domain.Film;
import com.cinema.clients.customer.model.FilmDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper
@DecoratedWith(FilmMapperDecorator.class)
public interface FilmMapper {

    FilmDto filmToFilmDto(Film film);

    Film filmDtoToFilm(FilmDto filmDto);


}
