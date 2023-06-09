package com.cinema.clients.customer.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class UserDto extends BaseItem {

    @Builder
    public UserDto(Long id,
                   Timestamp lastUpdate,
                   String name, String password,
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
    private byte[] picByte;
    private Double amountAvailable;
    private Double amountReserved;
}
