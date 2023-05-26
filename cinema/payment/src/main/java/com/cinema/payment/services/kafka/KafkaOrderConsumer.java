package com.cinema.payment.services.kafka;

import com.cinema.clients.order.OrderEventDto;
import com.cinema.payment.repositories.EmployeeRepository;
import com.cinema.payment.services.EmployeeService;
import com.cinema.payment.services.OrderManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaOrderConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaOrderConsumer.class);
    private final OrderManageService orderManageService;
    @Autowired
    public KafkaOrderConsumer(OrderManageService orderManageService) {
        this.orderManageService = orderManageService;
    }
    @KafkaListener(id = "order", topics = "payment-topic", groupId = "payment")
    public void onEvent(OrderEventDto orderEventDto) {
        LOGGER.info("Received: " + orderEventDto.toString());

        if(orderEventDto.getStatus().equals("NEW")) {
            orderManageService.reserve(orderEventDto);
        } else {
            orderManageService.confirm(orderEventDto);
        }
    }
}

