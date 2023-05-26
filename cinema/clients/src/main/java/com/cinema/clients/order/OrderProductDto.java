package com.cinema.clients.order;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class OrderProductDto extends BaseItem {

    @Builder
    public OrderProductDto(Long id,
                           Timestamp lastUpdate,
                           OrderDto order) {
        super(id, lastUpdate);
        this.order = order;
    }
    private OrderDto order;
}
