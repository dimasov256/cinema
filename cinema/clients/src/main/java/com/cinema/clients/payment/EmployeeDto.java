package com.cinema.clients.payment;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto extends BaseItem{

    @Builder
    public EmployeeDto(Long id,
                       Timestamp lastUpdate,
                       Long user_id,
                       String userName,
                       int amountAvailable,
                       int amountReserved) {
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
