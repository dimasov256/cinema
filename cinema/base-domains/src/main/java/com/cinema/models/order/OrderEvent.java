package com.cinema.models.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {//class using to pass data between producer and consumer
    private String message;
    private String status;
    private Order order;
}
