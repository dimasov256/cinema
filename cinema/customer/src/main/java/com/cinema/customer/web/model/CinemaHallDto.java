package com.cinema.customer.web.model;

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
                         boolean isBooked) {
        super(id, lastUpdate);
        this.name = name;
        this.location = location;
        this.capacities = capacities;
        this.isBooked = isBooked;
    }
    private String name;
    private String location;
    boolean isBooked = false;
    private List<LayoutCapacityDto> capacities;
    public void setCapacity(LayoutCapacityDto capacity) {
        for (LayoutCapacityDto lc : this.capacities) {
            if (lc.getLayout() == capacity.getLayout()) {
                lc.setCapacity(capacity.getCapacity());
            }
        }
    }

    public boolean isBooked() {
        return this.isBooked;
    }

    public void setBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CinemaHallDto;
    }

}
