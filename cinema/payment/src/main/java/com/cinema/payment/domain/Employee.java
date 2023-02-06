package com.cinema.payment.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "employee_table")
public class Employee extends BaseEntity {

    @Builder
    public Employee(Long id, Timestamp lastUpdate, Long user_id, String userName, int amountAvailable, int amountReserved) {
        super(id, lastUpdate);
        this.user_id = user_id;
        this.userName = userName;
        this.amountAvailable = amountAvailable;
        this.amountReserved = amountReserved;
    }

    private Long user_id;
    private String userName;
    private int amountAvailable;
    private int amountReserved;

}
