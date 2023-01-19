package com.cinema.customer.web.model;

import com.cinema.customer.domain.Layout;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class LayoutCapacityDto extends BaseItem {

    @Builder
    public LayoutCapacityDto(Long id, Timestamp lastUpdate, Layout layout, Integer capacity) {
        super(id, lastUpdate);
        this.layout = layout;
        this.capacity = capacity;
    }

    private Layout layout;
    private Integer capacity;
}
