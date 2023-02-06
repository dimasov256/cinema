package com.cinema.order.web.mappers;

import com.cinema.clients.order.OrderDto;
import com.cinema.order.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class OrderMapperDecorator implements OrderMapper {

    private OrderMapper orderMapper;

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderDto orderToOrderDto(Order order) {
        return orderMapper.orderToOrderDto(order);
    }

    @Override
    public Order orderDtoToOrder(OrderDto orderDto) {
        return orderMapper.orderDtoToOrder(orderDto);
    }
}
