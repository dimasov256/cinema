package com.cinema.clients.customer.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class CityDto extends BaseItem {

    @Builder
    public CityDto(Long id,
                   Timestamp lastUpdate,
                   String cityName) {
        super(id, lastUpdate);
        this.cityName = cityName;
    }
    private String cityName;
}