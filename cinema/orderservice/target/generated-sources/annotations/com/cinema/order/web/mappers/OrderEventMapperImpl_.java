package com.cinema.order.web.mappers;

import com.cinema.clients.order.OrderDto;
import com.cinema.clients.order.OrderDto.OrderDtoBuilder;
import com.cinema.clients.order.OrderEventDto;
import com.cinema.clients.order.OrderEventDto.OrderEventDtoBuilder;
import com.cinema.order.domain.Order;
import com.cinema.order.domain.Order.OrderBuilder;
import com.cinema.order.domain.OrderEvent;
import com.cinema.order.domain.OrderEvent.OrderEventBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-15T02:43:50+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
@Qualifier("delegate")
public class OrderEventMapperImpl_ implements OrderEventMapper {

    @Override
    public OrderEvent orderEventDtoToOrderEvent(OrderEventDto orderEventDto) {
        if ( orderEventDto == null ) {
            return null;
        }

        OrderEventBuilder orderEvent = OrderEvent.builder();

        orderEvent.id( orderEventDto.getId() );
        orderEvent.lastUpdate( orderEventDto.getLastUpdate() );
        orderEvent.message( orderEventDto.getMessage() );
        orderEvent.status( orderEventDto.getStatus() );
        orderEvent.order( orderDtoToOrder( orderEventDto.getOrder() ) );

        return orderEvent.build();
    }

    @Override
    public OrderEventDto orderEventToOrderEventDto(OrderEvent orderEvent) {
        if ( orderEvent == null ) {
            return null;
        }

        OrderEventDtoBuilder orderEventDto = OrderEventDto.builder();

        orderEventDto.id( orderEvent.getId() );
        orderEventDto.lastUpdate( orderEvent.getLastUpdate() );
        orderEventDto.message( orderEvent.getMessage() );
        orderEventDto.status( orderEvent.getStatus() );
        orderEventDto.order( orderToOrderDto( orderEvent.getOrder() ) );

        return orderEventDto.build();
    }

    protected Order orderDtoToOrder(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        OrderBuilder order = Order.builder();

        order.id( orderDto.getId() );
        order.lastUpdate( orderDto.getLastUpdate() );
        order.userId( orderDto.getUserId() );
        order.place( orderDto.getPlace() );
        order.orderName( orderDto.getOrderName() );
        order.price( orderDto.getPrice() );
        order.status( orderDto.getStatus() );
        order.source( orderDto.getSource() );

        return order.build();
    }

    protected OrderDto orderToOrderDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDtoBuilder orderDto = OrderDto.builder();

        orderDto.id( order.getId() );
        orderDto.lastUpdate( order.getLastUpdate() );
        orderDto.userId( order.getUserId() );
        orderDto.place( order.getPlace() );
        orderDto.orderName( order.getOrderName() );
        orderDto.price( order.getPrice() );
        orderDto.status( order.getStatus() );
        orderDto.source( order.getSource() );

        return orderDto.build();
    }
}
