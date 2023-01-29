package com.cinema.payment.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "employee_table")
public class Employee extends BaseEntity{

    public Employee(Long id,
                    Timestamp lastUpdate,
                    Long user_id) {
        super(id, lastUpdate);
        this.user_id = user_id;
    }

    private Long user_id;

}
