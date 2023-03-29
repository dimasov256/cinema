package com.cinema.customer.repositories;

import com.cinema.customer.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

    Film findFilmById(Long filmId);
    void deleteById(Long id);
    List<Film> findAllByDate(Date date);

}
