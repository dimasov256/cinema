package com.cinema.order.web.mappers;

import com.cinema.clients.order.OrderProductDto;
import com.cinema.order.domain.OrderProduct;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper
@DecoratedWith(OrderProductDecorator.class)
public interface OrderProductMapper {

    OrderProductDto orderProductToOrderProductDto(OrderProduct orderProduct);

    OrderProduct orderProductDtoToOrderProduct(OrderProductDto orderProductDto);
}
