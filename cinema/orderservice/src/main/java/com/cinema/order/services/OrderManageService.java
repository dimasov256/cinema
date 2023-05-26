package com.cinema.order.services;

import com.cinema.clients.customer.model.UserDto;
import com.cinema.clients.customer.user.UserClient;
import com.cinema.clients.order.OrderEventDto;
import com.cinema.order.domain.Order;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@AllArgsConstructor
public class OrderManageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderManageService.class);
    private static final String SOURCE = "payment";
    private UserClient userClient;
    private KafkaTemplate<Long, OrderEventDto> template;
    public OrderEventDto confirm(OrderEventDto orderEvenPayment, OrderEventDto payment, OrderEventDto stock) {

        if (payment.getOrder().getStatus().equals("ACCEPT") && stock.getOrder().getStatus().equals("ACCEPT")) {

            orderEvenPayment.getOrder().setStatus("CONFIRM");

        } else if (payment.getOrder().getStatus().equals("REJECT") && stock.getOrder().getStatus().equals("REJECT")) {

            orderEvenPayment.getOrder().setStatus("REJECT");

        } else if (payment.getOrder().getStatus().equals("REJECT") || stock.getOrder().getStatus().equals("REJECT")) {

            String source = payment.getStatus().equals("REJECT") ? "PAYMENT" : "STOCK";
            orderEvenPayment.getOrder().setStatus("ROLLBACK");
            orderEvenPayment.getOrder().setStatus(source);
            //TODO sent to customer rollback message
        }
        return orderEvenPayment;
    }
}
