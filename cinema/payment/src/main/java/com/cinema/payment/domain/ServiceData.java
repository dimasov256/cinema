package com.cinema.payment.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "service_data")
public class ServiceData extends BaseEntity {
    public ServiceData(Long id,
                       Timestamp lastUpdate) {
        super(id, lastUpdate);
    }

    @ManyToOne
    private Employee employee;

}
