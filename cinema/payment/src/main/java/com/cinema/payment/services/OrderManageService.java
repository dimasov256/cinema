package com.cinema.payment.services;


import com.cinema.clients.customer.user.UserClient;
import com.cinema.clients.customer.model.UserDto;
import com.cinema.clients.order.OrderEventDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderManageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderManageService.class);

    private static final String SOURCE = "payment";
    private final UserClient userClient;
    private KafkaTemplate<Long, OrderEventDto> template;

    public OrderManageService(KafkaTemplate<Long, OrderEventDto> template,
                              UserClient userClient) {
        this.template = template;
        this.userClient = userClient;
    }

    public void reserve(OrderEventDto orderEventDto) {

        UserDto userDto = userClient.getUserById(orderEventDto.getOrderDto().getUserId());

        LOGGER.info(String.format("Found user: %s", userDto));

        if (orderEventDto.getOrderDto().getPrice() < userDto.getAmountAvailable()) {

            orderEventDto.getOrderDto().setStatus("ACCEPT");
            userDto.setAmountReserved(userDto.getAmountReserved() + orderEventDto.getOrderDto().getPrice());
            userDto.setAmountReserved(userDto.getAmountAvailable() - orderEventDto.getOrderDto().getPrice());

        } else {
            orderEventDto.getOrderDto().setStatus("REJECTED");
        }
        orderEventDto.getOrderDto().setSource(SOURCE);
        userClient.createUser(userDto);
        template.send("payment-orders", orderEventDto.getId(), orderEventDto);
    }

    public void confirm(OrderEventDto orderEventDto) {

        UserDto userDto = userClient.getUserById(orderEventDto.getOrderDto().getUserId());
        LOGGER.info(String.format("Found user: %s", userDto.toString()));

        if (orderEventDto.getOrderDto().getStatus().equals("CONFIRMED")) {

            userDto.setAmountReserved(userDto.getAmountReserved() - orderEventDto.getOrderDto().getPrice());
            userClient.createUser(userDto);

        } else if (orderEventDto.getOrderDto().getStatus().equals("ROLLBACK") &&
                !orderEventDto.getOrderDto().getStatus().equals(SOURCE)) {

            userDto.setAmountReserved(userDto.getAmountReserved() - orderEventDto.getOrderDto().getPrice());
            userDto.setAmountAvailable(userDto.getAmountAvailable() + orderEventDto.getOrderDto().getPrice());
            userClient.createUser(userDto);
        }

    }
}
