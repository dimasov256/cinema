package com.cinema.clients.order;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class OrderEventDto extends BaseItem {//class using to pass data between producer and consumer

    @Builder
    public OrderEventDto(Long id, Timestamp lastUpdate, String message, String status, OrderDto orderDto) {
        super(id, lastUpdate);
        this.message = message;
        this.status = status;
        this.orderDto = orderDto;
    }
    private String message;
    private String status;
    private OrderDto orderDto;
}
