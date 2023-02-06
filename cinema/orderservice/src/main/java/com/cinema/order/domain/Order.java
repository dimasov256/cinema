package com.cinema.order.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "order_table")
public class Order extends BaseEntity{

    @Builder
    public Order(Long id,
                 Timestamp lastUpdate,
                 Long user_id,
                 String place,
                 String orderName,
                 double price,
                 String status,
                 String source) {
        super(id, lastUpdate);
        this.user_id = user_id;
        this.place = place;
        this.orderName = orderName;
        this.price = price;
        this.status = status;
        this.source = source;
    }
    private Long user_id;
    private String place;
    private String orderName;
    private double price;
    private String status;
    private String source;
}
