package com.cinema.clients.payment;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class EmployeeDto extends BaseItem{

    @Builder
    public EmployeeDto(Long id,
                    Timestamp lastUpdate,
                    Long user_id) {
        super(id, lastUpdate);
        this.user_id = user_id;
    }

    private Long user_id;
}
