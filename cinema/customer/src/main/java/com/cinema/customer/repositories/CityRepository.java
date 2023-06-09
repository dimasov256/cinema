package com.cinema.customer.repositories;

import com.cinema.customer.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
        City findCityByCityName(String name);
}
