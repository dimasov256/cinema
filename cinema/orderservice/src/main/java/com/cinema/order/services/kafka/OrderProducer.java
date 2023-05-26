package com.cinema.order.services.kafka;

import com.cinema.clients.order.OrderEventDto;
import com.cinema.order.services.OrderManageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static java.lang.String.format;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.kafka.support.KafkaHeaders.*;

@Slf4j
@Service
@AllArgsConstructor
public class OrderProducer {
    private static final Logger LOGGER = getLogger(OrderProducer.class);
    private NewTopic topic;
    private KafkaTemplate<Long, OrderEventDto> kafkaTemplate;
    private OrderManageService orderManageService;

    public void sendMessage(OrderEventDto orderEventDto) {

        LOGGER.info(format("Order event: %s", orderEventDto));

        Message<OrderEventDto> message = MessageBuilder
                .withPayload(orderEventDto)
                .setHeader(TOPIC, topic.name())
                .build();

        kafkaTemplate.send(message);

        log.info("Sent message with event: {}", orderEventDto);
    }
}
