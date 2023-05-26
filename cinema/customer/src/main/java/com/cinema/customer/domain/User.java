package com.cinema.customer.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;


@Data
@Entity
@NoArgsConstructor
@Table(name = "user_table")
public class User extends BaseEntity {
    @Builder
    public User(Long id,
                Timestamp lastUpdate,
                String name,
                String password,
                String email,
                byte[] picByte,
                Double amountAvailable,
                Double amountReserved) {
        super(id, lastUpdate);
        this.name = name;
        this.password = password;
        this.email = email;
        this.picByte = picByte;
        this.amountAvailable = amountAvailable;
        this.amountReserved = amountReserved;
    }
    private String name;
    private String password;
    private String email;
    @Column(name="picByte", length = 1000)
    private byte[] picByte;
    private Double amountAvailable;
    private Double amountReserved;
}
