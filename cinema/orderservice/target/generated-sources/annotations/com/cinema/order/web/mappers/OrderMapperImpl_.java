package com.cinema.order.web.mappers;

import com.cinema.clients.order.OrderDto;
import com.cinema.clients.order.OrderDto.OrderDtoBuilder;
import com.cinema.order.domain.Order;
import com.cinema.order.domain.Order.OrderBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-27T12:48:59+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
@Qualifier("delegate")
public class OrderMapperImpl_ implements OrderMapper {

    @Override
    public OrderDto orderToOrderDto(Order order) {
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

    @Override
    public Order orderDtoToOrder(OrderDto orderDto) {
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
}
