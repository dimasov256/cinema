package com.cinema.customer.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cinema_hall")
public class CinemaHall extends BaseEntity {

    @Builder
    public CinemaHall(Long id,
                      Timestamp lastUpdate,
                      String name,
                      String location,
                      List<LayoutCapacity> capacities,
                      boolean isBooked,
                      City city) {
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
    @ManyToOne
    private City city;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<LayoutCapacity> capacities;
    public void setCapacity(LayoutCapacity capacity) {
        if (this.capacities == null) {
            this.capacities = new ArrayList<>();
        }
        this.capacities.add(capacity);
    }
}
