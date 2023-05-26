package com.cinema.payment.services;


import com.cinema.clients.customer.user.UserClient;
import com.cinema.clients.customer.model.UserDto;
import com.cinema.clients.order.OrderEventDto;
import lombok.AllArgsConstructor;
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
    private final UserClient userClient;
    private KafkaTemplate<Long, OrderEventDto> template;

    public void reserve(OrderEventDto orderEventDto) {

        UserDto userDto = userClient.getUserById(orderEventDto.getOrder().getUserId());

        LOGGER.info(format("Found user: %s", userDto));

        if (orderEventDto.getOrder().getPrice() < userDto.getAmountAvailable()) {

            orderEventDto.getOrder().setStatus("ACCEPT");
            userDto.setAmountReserved(userDto.getAmountReserved() + orderEventDto.getOrder().getPrice());
            userDto.setAmountReserved(userDto.getAmountAvailable() - orderEventDto.getOrder().getPrice());

        } else {
            orderEventDto.getOrder().setStatus("REJECTED");
        }

        orderEventDto.getOrder().setSource(SOURCE);
        userClient.updateUser(userDto.getId(), userDto);
        template.send("payment-topic", orderEventDto.getId(), orderEventDto);
        //TODO: sent to SMS topic for customer
        //TODO Sent to notification message about reserve

    }

    public void confirm(OrderEventDto orderEventDto) {

        UserDto userDto = userClient.getUserById(orderEventDto.getOrder().getUserId());

        LOGGER.info(format("Found user: %s", userDto.toString()));

        if (orderEventDto.getOrder().getStatus().equals("CONFIRMED")) {

            userDto.setAmountReserved(userDto.getAmountReserved() - orderEventDto.getOrder().getPrice());
            userClient.createUser(userDto);
            //TODO sent to customer notification about confirmation
            template.send("stock-topic", orderEventDto.getId(), orderEventDto);

        } else if (orderEventDto.getOrder().getStatus().equals("ROLLBACK") &&
                !orderEventDto.getOrder().getStatus().equals(SOURCE)) {

            userDto.setAmountReserved(userDto.getAmountReserved() - orderEventDto.getOrder().getPrice());
            userDto.setAmountAvailable(userDto.getAmountAvailable() + orderEventDto.getOrder().getPrice());

            userClient.updateUser(userDto.getId(), userDto);

        }

    }
}
