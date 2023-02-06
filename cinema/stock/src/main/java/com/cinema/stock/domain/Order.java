package com.cinema.stock.domain;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "order_table")
public class Order extends BaseEntity{

    @Builder
    public Order(Long id, Timestamp lastUpdate, Long cinemaHallId, Integer quantity, Double price) {
        super(id, lastUpdate);
        this.cinemaHallId = cinemaHallId;
        this.quantity = quantity;
        this.price = price;
    }
    private Long cinemaHallId;
    private Integer quantity;
    private Double price;
}
