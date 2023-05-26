package com.cinema.order.services;

import com.cinema.clients.order.OrderDto;
import com.cinema.order.repositories.OrderRepository;
import com.cinema.order.web.mappers.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderDto> findAllOrders() {
        return orderRepository.findAll().stream().map(orderMapper::orderToOrderDto).collect(Collectors.toList());
    }
}
