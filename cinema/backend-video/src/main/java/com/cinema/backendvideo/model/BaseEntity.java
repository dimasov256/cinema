package com.cinema.backendvideo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
public class BaseEntity {

    public BaseEntity(String  id, Timestamp lastUpdate) {
        this.id = id;
        this.lastUpdate = lastUpdate;
    }

    @Id
    private String id;
    private Timestamp lastUpdate;
}
