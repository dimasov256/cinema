package com.cinema.stock.services;

import com.cinema.clients.customer.cinemahall.CinemaHallClient;
import com.cinema.clients.customer.model.CinemaHallDto;
import com.cinema.clients.order.OrderEventDto;
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

        //TODO: write a transaction entity
//        Transaction transaction = transactionRepository.findById(1L).orElseThrow(() -> new RuntimeException("Transaction is not exist"));

        CinemaHallDto cinemaHall = cinemaHallClient.getCinemaHallByLocation(orderEventDto.getOrder().getPlace());

//        LOGGER.info(String.format("Found: %s", transaction));

        if (orderEventDto.getOrder().getStatus().equals("NEW")) {
            if (!cinemaHall.isBooked()) {
                orderEventDto.getOrder().setStatus("ACCEPTED");
                cinemaHall.setBooked(true);
                cinemaHallClient.updateCinemaHall(cinemaHall.getId(), cinemaHall);
//                transactionRepository.save(transaction);
            }  else {
                orderEventDto.getOrder().setStatus("REJECTED");
            }
            template.send("stock-topic", orderEventDto.getId(), orderEventDto);
        }
    }
}
