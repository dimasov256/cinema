package com.cinema.email.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {

    public BaseEntity(Long id, Timestamp lastUpdate) {
        this.id = id;
        this.lastUpdate = lastUpdate;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    @UpdateTimestamp
    private Timestamp lastUpdate;
}
