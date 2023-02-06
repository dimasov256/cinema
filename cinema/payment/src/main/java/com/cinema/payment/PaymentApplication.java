package com.cinema.payment;


import com.cinema.payment.domain.Employee;
import com.cinema.payment.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;
import java.util.Random;


@SpringBootApplication
@EnableFeignClients(
        basePackages = "com.cinema.clients.customer"
)
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

//    @PostConstruct
//    public void generateData() {
////        Random r = new Random();
////
////        for (int i = 0; i < 100; i++) {
////            int count = r.nextInt(1000);
////            Employee employee = Employee.builder()
////                    .id(1L)
////                    .amountAvailable(15000)
////                    .amountReserved(123)
////                    .build();
////            employeeRepository.save(employee);
////        }
//    }
}
