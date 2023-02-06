package com.cinema.customer.domain;


import com.cinema.clients.customer.model.Layout;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@Table(name = "film")
public class Film extends BaseEntity {

    @Builder
    public Film(Long id,
                Timestamp lastUpdate,
                CinemaHall cinemaHall,
                User user,
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
    @ManyToOne
    private CinemaHall cinemaHall;
    @ManyToOne
    private User user;
    private Layout layout;
    private String title;
    private Date date;
    private Time startTime;
    private Time endTime;
    private Integer participants;
}
