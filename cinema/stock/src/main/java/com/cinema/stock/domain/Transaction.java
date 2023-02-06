package com.cinema.stock.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "transaction")
@NoArgsConstructor
public class Transaction extends BaseEntity{

    @Builder
    public Transaction(Long id,
                       Timestamp lastUpdate,
                       Long userId, Date date,
                       Integer quantity,
                       Integer totalAmount) {
        super(id, lastUpdate);
        this.userId = userId;
        this.date = date;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    private Long userId;
    private Date date;
    private Integer quantity;
    private Integer totalAmount;
    //TODO: adding filed when creating order
    private Long orderId;
}
