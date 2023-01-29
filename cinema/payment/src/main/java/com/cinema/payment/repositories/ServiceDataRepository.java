package com.cinema.payment.repositories;

import com.cinema.payment.domain.ServiceData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceDataRepository extends JpaRepository<ServiceData, Long> {
}
