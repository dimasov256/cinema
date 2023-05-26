package com.cinema.clients.order;

import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseItem {

    private Long id;

    private Timestamp lastUpdate;

}
