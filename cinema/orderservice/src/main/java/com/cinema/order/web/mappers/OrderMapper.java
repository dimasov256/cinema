package com.cinema.order.web.mappers;

import com.cinema.clients.order.OrderDto;
import com.cinema.order.domain.Order;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper
@DecoratedWith(OrderMapperDecorator.class)
public interface OrderMapper {

    OrderDto orderToOrderDto(Order order);

    Order orderDtoToOrder(OrderDto orderDto);
}
