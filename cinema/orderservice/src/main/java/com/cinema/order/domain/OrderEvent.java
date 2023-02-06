package com.cinema.order.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "order_event")
public class OrderEvent extends BaseEntity{

    @Builder
    public OrderEvent(Long id, Timestamp lastUpdate, String message, String status, Order order) {
        super(id, lastUpdate);
        this.message = message;
        this.status = status;
        this.order = order;
    }
    private String message;
    private String status;
    @ManyToOne
    private Order order;
}
