package com.cinema.order.web.controllers;

//import com.cinema.models.order.Order;
//import com.cinema.models.order.OrderEvent;
import com.cinema.clients.order.OrderDto;
import com.cinema.clients.order.OrderEventDto;
import com.cinema.order.services.kafka.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderProducer orderProducer;

    @Autowired
    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String palaceOrder(@RequestBody OrderDto orderDto) {

        OrderEventDto orderEventDto = new OrderEventDto();
        orderEventDto.setStatus("PENDING");
        orderEventDto.setMessage("Order status is in pending status");
        orderEventDto.setOrderDto(orderDto);

        orderProducer.sendMessage(orderEventDto);
        //TODO: save event to DB

        return "Order placed successfully...";
    }
}
