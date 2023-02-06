package com.cinema.order.web.mappers;

import com.cinema.clients.order.OrderEventDto;
import com.cinema.order.domain.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class OrderEventMapperDecorator implements OrderEventMapper{

    private OrderEventMapper orderEventMapper;

    @Autowired
    public void setOrderEventMapper(OrderEventMapper orderEventMapper) {
        this.orderEventMapper = orderEventMapper;
    }

    @Override
    public OrderEvent orderEventDtoToOrderEvent(OrderEventDto orderEventDto) {
        return orderEventMapper.orderEventDtoToOrderEvent(orderEventDto);
    }

    @Override
    public OrderEventDto orderEventToOrderEventDto(OrderEvent orderEvent) {
        return orderEventMapper.orderEventToOrderEventDto(orderEvent);
    }
}
