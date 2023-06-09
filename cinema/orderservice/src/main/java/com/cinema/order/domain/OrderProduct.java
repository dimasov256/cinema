package com.cinema.order.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "order_product_table")
public class OrderProduct extends BaseEntity {

    @Builder
    public OrderProduct(Long id,
                        Timestamp lastUpdate,
                        Order order) {
        super(id, lastUpdate);
        this.order = order;
    }
    @ManyToOne
    private Order order;
}
