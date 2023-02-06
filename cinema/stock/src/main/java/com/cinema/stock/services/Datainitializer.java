package com.cinema.stock.services;

import com.cinema.stock.domain.Transaction;
import com.cinema.stock.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Datainitializer {

    @Autowired
    TransactionRepository transactionRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        List<Transaction> transactionsList = transactionRepository.findAll();

        if(transactionsList.isEmpty()) {
            Transaction transaction1 = Transaction.builder()
                    .date(Date.valueOf(LocalDate.now()))
                    .userId(1L)
                    .totalAmount(1)
                    .quantity(12)
                    .build();

            transactionRepository.save(transaction1);
        }

    }
}
