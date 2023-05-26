package com.cinema.order.web.controllers;

import com.cinema.clients.order.OrderDto;
import com.cinema.clients.order.OrderEventDto;
import com.cinema.order.domain.Order;
import com.cinema.order.domain.OrderEvent;
import com.cinema.order.services.OrderEventService;
import com.cinema.order.services.OrderService;
import com.cinema.order.services.criteria.OrderSearchDao;
import com.cinema.order.services.kafka.OrderProducer;
import com.cinema.order.web.mappers.OrderEventMapper;
import com.cinema.order.web.mappers.OrderMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class OrderController {

    private final OrderEventService orderEventService;
    private final OrderService orderService;

    private final OrderSearchDao orderSearchDao;

    @PostMapping("/orders")
    public OrderEventDto palaceOrder(@RequestBody OrderDto orderDto) {
        return orderEventService.palaceOrder(orderDto);
    }

    @GetMapping("/allOrders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return new ResponseEntity<>(orderService.findAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/orders/{orderName}")
    public ResponseEntity<List<Order>> getByName(@PathVariable("orderName") String orderName) {
        return new ResponseEntity<>(orderSearchDao.findAllOrdersByName(orderName), HttpStatus.OK);
    }
}
