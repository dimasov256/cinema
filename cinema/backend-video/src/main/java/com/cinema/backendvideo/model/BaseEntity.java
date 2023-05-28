package com.cinema.backendvideo.model;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@NoArgsConstructor
public class BaseEntity {

    public BaseEntity(Long id, Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Id
    private String id;
    private Timestamp lastUpdate;
}
