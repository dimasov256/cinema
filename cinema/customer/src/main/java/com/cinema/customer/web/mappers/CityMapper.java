package com.cinema.customer.web.mappers;

import com.cinema.clients.customer.model.CityDto;
import com.cinema.customer.domain.City;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper
@DecoratedWith(CItyMapperDecorator.class)
public interface CityMapper {

    CityDto cityToCityDto(City city);
    City cityDtoToCity(CityDto city);
}
