package com.cinema.clients.payment;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class ServiceDataDto extends BaseItem{

    @Builder
    public ServiceDataDto(Long id,
                       Timestamp lastUpdate) {
        super(id, lastUpdate);
    }

    private EmployeeDto employee;
}
