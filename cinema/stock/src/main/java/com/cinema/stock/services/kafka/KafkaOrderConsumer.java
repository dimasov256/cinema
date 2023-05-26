package com.cinema.stock.services.kafka;

import com.cinema.clients.order.OrderEventDto;
import com.cinema.stock.services.OrderManageService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaOrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaOrderConsumer.class);

    private final OrderManageService orderManageService;

    @KafkaListener(id = "order", topics = "order-topic", groupId = "payment")
    public void onEvent(OrderEventDto orderEventDto) {
        LOGGER.info(String.format("Receive: %s", orderEventDto));
        if (orderEventDto.getOrder().getStatus().equals("NEW")) {
            orderManageService.reserve(orderEventDto);
        } else {
            System.out.println("Else");
        }
    }
}
