package com.cinema.order.web.mappers;

import com.cinema.clients.order.OrderProductDto;
import com.cinema.order.domain.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class OrderProductDecorator implements OrderProductMapper{
    private OrderProductMapper orderProductMapper;

    @Autowired
    public void setOrderProductMapper(OrderProductMapper orderProductMapper) {
        this.orderProductMapper = orderProductMapper;
    }

    @Override
    public OrderProductDto orderProductToOrderProductDto(OrderProduct orderProduct) {
        return orderProductMapper.orderProductToOrderProductDto(orderProduct);
    }

    @Override
    public OrderProduct orderProductDtoToOrderProduct(OrderProductDto orderProductDto) {
        return orderProductMapper.orderProductDtoToOrderProduct(orderProductDto);
    }
}
