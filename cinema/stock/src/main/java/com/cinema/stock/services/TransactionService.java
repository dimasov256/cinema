package com.cinema.stock.services;

import com.cinema.stock.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    //TODO: implements methods to convert domain to DTO
}
