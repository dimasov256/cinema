package com.cinema.customer.services;

import com.cinema.clients.customer.model.CityDto;
import com.cinema.customer.repositories.CityRepository;
import com.cinema.customer.web.mappers.CityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityMapper cityMapper;
    private final CityRepository cityRepository;
    public List<CityDto> getAllCities() {
        return cityRepository.findAll().stream().map(cityMapper::cityToCityDto).collect(Collectors.toList());
    }
}
