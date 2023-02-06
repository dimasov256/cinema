package com.cinema.stock.services;

import com.cinema.clients.customer.cinemahall.CinemaHallClient;
import com.cinema.clients.customer.model.CinemaHallDto;
import com.cinema.clients.order.OrderEventDto;
import com.cinema.stock.domain.Transaction;
import com.cinema.stock.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderManageService {

    private static final String SOURCE = "stock";
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderManageService.class);
    private TransactionRepository transactionRepository;
    private KafkaTemplate<Long, OrderEventDto> template;
    private final CinemaHallClient cinemaHallClient;

    public void reserve(OrderEventDto orderEventDto) {
        Transaction transaction = transactionRepository.getById(1L);
        CinemaHallDto cinemaHall = cinemaHallClient.getCinemaHallByLocation(orderEventDto.getOrderDto().getPlace());
        LOGGER.info(String.format("Found: %s", transaction));

        if (orderEventDto.getOrderDto().getStatus().equals("NEW")) {
            if (cinemaHall.isBooked()) {
                orderEventDto.getOrderDto().setStatus("ACCEPTED");
                transactionRepository.save(transaction);
            }  else {
                orderEventDto.getOrderDto().setStatus("REJECTED");
            }
            template.send("stock-topic", orderEventDto.getId(), orderEventDto);
        }
    }
}
