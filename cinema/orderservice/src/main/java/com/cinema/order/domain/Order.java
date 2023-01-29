package com.cinema.order.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "order_table")
public class Order extends BaseEntity{

    public Order(Long id, Timestamp lastUpdate, Long user_id) {
        super(id, lastUpdate);
        this.user_id = user_id;
    }

    private Long user_id;
}
