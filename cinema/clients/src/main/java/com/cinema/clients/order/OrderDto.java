package com.cinema.clients.order;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class OrderDto extends BaseItem {

    @Builder
    public OrderDto(Long id,
                    Timestamp lastUpdate,
                    Long userId,
                    String place,
                    String orderName,
                    double price,
                    String status,
                    String source) {
        super(id, lastUpdate);
        this.userId = userId;
        this.place = place;
        this.orderName = orderName;
        this.price = price;
        this.status = status;
        this.source = source;
    }

    private Long userId;
    private String place;
    private String orderName;
    private double price;
    private String status;
    private String source;
}
