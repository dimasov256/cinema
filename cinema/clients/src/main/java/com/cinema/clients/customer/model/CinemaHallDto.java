package com.cinema.clients.customer.model;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
public class CinemaHallDto extends BaseItem {

    @Builder
    public CinemaHallDto(Long id,
                         Timestamp lastUpdate,
                         String name,
                         String location,
                         List<LayoutCapacityDto> capacities,
                         boolean isBooked,
                         CityDto city) {
        super(id, lastUpdate);
        this.name = name;
        this.location = location;
        this.capacities = capacities;
        this.isBooked = isBooked;
        this.city = city;
    }

    private String name;
    private String location;
    private boolean isBooked;
    private List<LayoutCapacityDto> capacities;
    private CityDto city;
    public void setCapacity(LayoutCapacityDto capacity) {
        for (LayoutCapacityDto lc : this.capacities) {
            if (lc.getLayout() == capacity.getLayout()) {
                lc.setCapacity(capacity.getCapacity());
            }
        }
    }
}
