package com.cinema.customer.web.mappers;


import com.cinema.customer.domain.Film;
import com.cinema.clients.customer.model.FilmDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class FilmMapperDecorator implements FilmMapper {

    private FilmMapper filmMapper;

    @Autowired
    public void setFilmMapper(FilmMapper filmMapper) {
        this.filmMapper = filmMapper;
    }

    @Override
    public FilmDto filmToFilmDto(Film film) {
        return filmMapper.filmToFilmDto(film);
    }

    @Override
    public Film filmDtoToFilm(FilmDto filmDto) {
        return filmMapper.filmDtoToFilm(filmDto);
    }


}
