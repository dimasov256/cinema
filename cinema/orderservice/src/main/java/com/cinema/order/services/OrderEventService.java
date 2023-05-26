package com.cinema.order.services;

import com.cinema.clients.order.OrderDto;
import com.cinema.clients.order.OrderEventDto;
import com.cinema.order.domain.Order;
import com.cinema.order.domain.OrderEvent;
import com.cinema.order.repositories.OrderEventRepository;
import com.cinema.order.services.kafka.OrderProducer;
import com.cinema.order.web.mappers.OrderEventMapper;
import com.cinema.order.web.mappers.OrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class OrderEventService {
    private final OrderEventRepository orderEventRepository;
    private final OrderEventMapper orderEventMapper;
    private final OrderProducer orderProducer;
    private final OrderMapper orderMapper;

    public OrderEventDto saveOrderEvent(OrderEventDto orderEventDto) {

        if (orderEventDto == null) {
            throw new NullPointerException("Order event dto is null");
        }

        log.info("Saved message with event: {}", orderEventDto);
        return orderEventMapper
                .orderEventToOrderEventDto(orderEventRepository
                        .save(orderEventMapper.orderEventDtoToOrderEvent(orderEventDto)));
    }

    public OrderEventDto palaceOrder(OrderDto orderDto) {

        Order newOrder = orderMapper.orderDtoToOrder(orderDto);

        OrderEvent orderEvent = OrderEvent.builder().build();

        orderEvent.setStatus(newOrder.getStatus());

        orderEvent.setMessage("Order status is in pending status");

        orderEvent.setOrder(newOrder);

       OrderEventDto savedOrderEvent = saveOrderEvent(orderEventMapper.orderEventToOrderEventDto(orderEvent));

        orderProducer.sendMessage(savedOrderEvent);

        return savedOrderEvent;
    }
}
