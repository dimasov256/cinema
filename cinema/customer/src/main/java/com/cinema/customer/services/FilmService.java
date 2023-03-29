package com.cinema.customer.services;

import com.cinema.clients.order.OrderDto;
import com.cinema.clients.order.OrderClient;
import com.cinema.customer.repositories.FilmRepository;
import com.cinema.customer.web.mappers.FilmMapper;
import com.cinema.clients.customer.model.FilmDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.sql.Timestamp.valueOf;
import static java.time.LocalDateTime.now;


@Slf4j
@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;
    private final OrderClient orderClient;


    public List<FilmDto> getAllFilms() {
        return filmRepository.findAll().stream()
                .map(filmMapper::filmToFilmDto)
                .collect(Collectors.toList());
    }

    public FilmDto findFilmById(Long filmId) {
        return filmMapper.filmToFilmDto(filmRepository.findById(filmId)
                .orElseThrow(() -> new RuntimeException("Film not present. Film ID: " + filmId)));
    }

    public FilmDto createFilm(FilmDto filmDto) {

        OrderDto orderDto = OrderDto.builder()
                .id(1L)
                .lastUpdate(valueOf(now()))
                .orderName(filmDto.getTitle())
                .price(24.90)
                .place(filmDto.getCinemaHall().getLocation())
                .userId(filmDto.getUser().getId())
                .status("NEW")
                .build();

        log.info("Publishing info {} ", orderDto);

        orderClient.palaceOrder(orderDto);

        log.info("Published info {} ", orderDto);

        return filmMapper.filmToFilmDto(filmRepository.save(filmMapper.filmDtoToFilm(filmDto)));
    }

    public void deleteFilm(Long filmId) {
        filmRepository.deleteById(filmId);
    }

    public FilmDto updateFilm(Long filmId, FilmDto filmDto) {

        FilmDto filmToSave = filmMapper.filmToFilmDto(filmRepository.findFilmById(filmId));

        filmToSave.setLayout(filmDto.getLayout());
        filmToSave.setParticipants(filmDto.getParticipants());
        filmToSave.setStartTime(filmDto.getStartTime());
        filmToSave.setEndTime(filmDto.getEndTime());
        filmToSave.setTitle(filmDto.getTitle());
        filmToSave.setUser(filmDto.getUser());
        filmToSave.setCinemaHall(filmDto.getCinemaHall());
        filmToSave.setDate(filmDto.getDate());

        return filmMapper.filmToFilmDto(filmRepository.save(filmMapper.filmDtoToFilm(filmToSave)));
    }

    public List<FilmDto> findAllByDate(String date) {
        Date sqlDate = Date.valueOf(date);
        return filmRepository.findAllByDate(sqlDate).stream().map(filmMapper::filmToFilmDto).collect(Collectors.toList());
    }

}
