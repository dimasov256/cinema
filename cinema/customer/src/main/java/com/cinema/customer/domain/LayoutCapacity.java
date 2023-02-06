package com.cinema.customer.domain;

import com.cinema.clients.customer.model.Layout;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;


@Data
@Entity
@NoArgsConstructor
@Table(name = "layout_capacity")
public class LayoutCapacity extends BaseEntity {

    @Builder
    public LayoutCapacity(Long id, Timestamp lastUpdate, Layout layout, Integer capacity) {
        super(id, lastUpdate);
        this.layout = layout;
        this.capacity = capacity;
    }
    private Layout layout;
    private Integer capacity;
}
