package com.cinema.clients.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseItem {

    private Long id;

    private Timestamp lastUpdate;
}
