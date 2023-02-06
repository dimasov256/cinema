package com.cinema.order.web.mappers;

import com.cinema.clients.order.OrderEventDto;
import com.cinema.clients.order.OrderEventDto.OrderEventDtoBuilder;
import com.cinema.order.domain.OrderEvent;
import com.cinema.order.domain.OrderEvent.OrderEventBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-02T12:22:49+0200",
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

        return orderEventDto.build();
    }
}
