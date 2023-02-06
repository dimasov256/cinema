package com.cinema.order.web.mappers;

import com.cinema.clients.order.OrderEventDto;
import com.cinema.order.domain.OrderEvent;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper
@DecoratedWith(OrderEventMapperDecorator.class)
public interface OrderEventMapper {

    OrderEvent orderEventDtoToOrderEvent(OrderEventDto orderEventDto);

    OrderEventDto orderEventToOrderEventDto(OrderEvent orderEvent);
}
