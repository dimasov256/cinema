package com.cinema.customer.web.mappers;

import com.cinema.clients.customer.model.CityDto;
import com.cinema.customer.domain.City;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CItyMapperDecorator implements CityMapper{

    private CityMapper cityMapper;

    @Autowired
    public void setCityMapper(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    @Override
    public CityDto cityToCityDto(City city) {
        return cityMapper.cityToCityDto(city);
    }

    @Override
    public City cityDtoToCity(CityDto cityDto) {
        return cityMapper.cityDtoToCity(cityDto);
    }
}
