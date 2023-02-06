package com.cinema.stock;

import com.cinema.clients.payment.EmployeeDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients(
        basePackages = "com.cinema.clients.customer"
)
public class StockApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }
}

