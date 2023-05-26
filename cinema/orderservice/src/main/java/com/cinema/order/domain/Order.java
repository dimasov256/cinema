package com.cinema.order.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "order_table")
@NoArgsConstructor
public class Order extends BaseEntity {

    @Builder
    public Order(Long id,
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
