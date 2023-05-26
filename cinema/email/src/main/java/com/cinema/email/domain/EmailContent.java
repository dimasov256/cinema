package com.cinema.email.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@Table(name = "email_content_table")
public class EmailContent extends BaseEntity{

    @Builder
    public EmailContent(Long id,
                        Timestamp lastUpdate,
                        String orderName,
                        Long orderId,
                        String text,
                        String email) {
        super(id, lastUpdate);
        this.orderName = orderName;
        this.orderId = orderId;
        this.text = text;
        this.email = email;
    }

    private String orderName;
    private Long orderId;
    private String text;
    private String email;
}
