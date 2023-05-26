package com.cinema.clients.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("localhost:8083/api/v1")
public interface OrderClient {

    @PostMapping("/orders")
    OrderEventDto palaceOrder(@RequestBody OrderDto orderDto);
}
