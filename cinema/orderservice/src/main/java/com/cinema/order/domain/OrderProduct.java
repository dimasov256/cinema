package com.cinema.order.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "order_product")
public class OrderProduct extends BaseEntity {

    public OrderProduct(Long id,
                        Timestamp lastUpdate,
                        Long productId) {
        super(id, lastUpdate);
        this.productId = productId;
    }

    @ManyToOne
    private Order order;
    private Long productId;
}
