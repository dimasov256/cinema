package com.cinema.order.domain;


import com.cinema.clients.order.OrderDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "order_event_table")
public class OrderEvent extends BaseEntity {

    @Builder
    public OrderEvent(Long id,
                      Timestamp lastUpdate,
                      String message,
                      String status,
                      Order order) {
        super(id, lastUpdate);
        this.message = message;
        this.status = status;
        this.order = order;
    }
    private Long userId;
    private String message;
    private String status;
    @ManyToOne
    private Order order;
}
