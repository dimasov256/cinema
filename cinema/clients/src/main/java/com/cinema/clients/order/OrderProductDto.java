package com.cinema.clients.order;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class OrderProductDto extends BaseItem{

    @Builder
    public OrderProductDto(Long id, Timestamp lastUpdate, OrderDto order) {
        super(id, lastUpdate);
        this.order = order;
    }
    private OrderDto order;
}
