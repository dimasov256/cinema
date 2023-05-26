package com.cinema.order.services;

import com.cinema.order.domain.Order;
import com.cinema.order.domain.OrderEvent;
import com.cinema.order.repositories.OrderEventRepository;
import com.cinema.order.repositories.OrderProductRepository;
import com.cinema.order.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class DataInitialization {
    OrderEventRepository orderEventRepository;
    OrderProductRepository orderProductRepository;
    OrderRepository orderRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        Order order = Order.builder()
                .price(234)
                .orderName("Movie")
                .place("Kirovski skver")
                .status("Ordered")
                .source("Some source")
                .userId(1L)
                .build();

        Order order2 = Order.builder()
                .price(234)
                .orderName("Movie")
                .place("Kirovski skver")
                .status("Ordered")
                .source("Some source")
                .userId(1L)
                .build();

        orderRepository.saveAll(Arrays.asList(order, order2));

        OrderEvent orderEvent = OrderEvent.builder()
                .message("new order event from Initializer")
                .order(order)
                .status("Some status")
                .message("Created order")
                .build();

        orderEventRepository.save(orderEvent);

        System.out.println("Saved data...");

    }
}
