package com.cinema.customer.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;


@Data
@Entity
@NoArgsConstructor
@Table(name = "city_table")
public class City extends BaseEntity {

    @Builder
    public City(Long id,
                Timestamp lastUpdate,
                String cityName) {
        super(id, lastUpdate);
        this.cityName = cityName;
    }

    private String cityName;
}
