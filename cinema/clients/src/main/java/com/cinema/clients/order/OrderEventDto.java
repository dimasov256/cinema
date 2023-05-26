package com.cinema.clients.order;

import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class OrderEventDto extends BaseItem {

    @Builder
    public OrderEventDto(Long id,
                         Timestamp lastUpdate,
                         String message,
                         String status,
                         OrderDto order) {
        super(id, lastUpdate);
        this.message = message;
        this.status = status;
        this.order = order;
    }

    private String message;
    private String status;
    private OrderDto order;
}
