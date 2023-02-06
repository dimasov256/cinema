package com.cinema.clients.customer.model;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class FilmDto extends BaseItem {

    @Builder
    public FilmDto(Long id,
                   Timestamp lastUpdate,
                   CinemaHallDto cinemaHall,
                   UserDto user,
                   Layout layout,
                   String title,
                   Date date,
                   Time startTime,
                   Time endTime,
                   Integer participants) {
        super(id, lastUpdate);
        this.cinemaHall = cinemaHall;
        this.user = user;
        this.layout = layout;
        this.title = title;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.participants = participants;
    }

    private CinemaHallDto cinemaHall;

    private UserDto user;

    private Layout layout;

    private String title;

    private Date date;

    private Time startTime;

    private Time endTime;

    private Integer participants;
}
