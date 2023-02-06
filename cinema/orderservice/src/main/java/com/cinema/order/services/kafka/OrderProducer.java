package com.cinema.order.services.kafka;

import com.cinema.clients.order.OrderEventDto;
import com.cinema.order.services.OrderEventService;
import com.cinema.order.services.OrderManageService;
import com.cinema.order.web.mappers.OrderEventMapper;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class OrderProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);
    private NewTopic topic;
    private KafkaTemplate<String, OrderEventDto> kafkaTemplate;
    private final OrderManageService orderManageService;
    private final OrderEventMapper orderEventMapper;

    private final OrderEventService orderEventService;

    @Autowired
    public OrderProducer(NewTopic topic,
                         KafkaTemplate<String, OrderEventDto> kafkaTemplate,
                         OrderManageService orderManageService,
                         OrderEventMapper orderEventMapper,
                         OrderEventService orderEventService) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
        this.orderManageService = orderManageService;
        this.orderEventMapper = orderEventMapper;
        this.orderEventService = orderEventService;
    }

    public void sendMessage(OrderEventDto orderEventDto) {
        LOGGER.info(String.format("Order event: %s", orderEventDto.toString()));

        //create message
        Message<OrderEventDto> message = MessageBuilder
                .withPayload(orderEventDto)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();

        orderEventService.saveOrderEvent(orderEventDto);

        kafkaTemplate.send(message);
    }
}
