package com.cinema.order.services;

import com.cinema.clients.order.OrderEventDto;
import com.cinema.order.repositories.OrderEventRepository;
import com.cinema.order.web.mappers.OrderEventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderEventService {

    private final OrderEventRepository orderEventRepository;
    private final OrderEventMapper orderEventMapper;

    public OrderEventDto saveOrderEvent(OrderEventDto orderEventDto) {


        return orderEventMapper
                .orderEventToOrderEventDto(orderEventRepository
                        .save(orderEventMapper
                                .orderEventDtoToOrderEvent(orderEventDto)));
    }
}
