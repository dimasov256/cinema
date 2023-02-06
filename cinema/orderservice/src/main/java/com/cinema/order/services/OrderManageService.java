package com.cinema.order.services;

import com.cinema.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderManageService {

    private final OrderEventService orderEventService;

    public Order confirm(Order payment, Order stock) {

        Order order = Order.builder()
                .id(payment.getId())
                .place(payment.getPlace())
                .orderName(payment.getOrderName())
                .lastUpdate(payment.getLastUpdate())
                .price(payment.getPrice())
                .user_id(payment.getUser_id())
                .build();

        if (payment.getStatus().equals("ACCEPT") && stock.getStatus().equals("ACCEPT")) {
            order.setStatus("CONFIRM");
        } else if (payment.getStatus().equals("REJECT") && stock.getStatus().equals("REJECT")) {
            order.setStatus("REJECT");
        } else if (payment.getStatus().equals("REJECT") || stock.getStatus().equals("REJECT")) {
            String source = payment.getStatus().equals("REJECT") ? "PAYMENT" : "STOCK";
            order.setStatus("ROLLBACK");
            order.setStatus(source);
        }

        return order;
    }
}
