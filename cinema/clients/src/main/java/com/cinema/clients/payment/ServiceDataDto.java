package com.cinema.clients.payment;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class ServiceDataDto extends BaseItem{

    @Builder
    public ServiceDataDto(Long id,
                       Timestamp lastUpdate) {
        super(id, lastUpdate);
    }

    private EmployeeDto employee;
}
