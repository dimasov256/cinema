package com.cinema.customer.web.mappers;

import com.cinema.clients.customer.model.CityDto;
import com.cinema.clients.customer.model.CityDto.CityDtoBuilder;
import com.cinema.customer.domain.City;
import com.cinema.customer.domain.City.CityBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-02T07:30:57+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
@Qualifier("delegate")
public class CityMapperImpl_ implements CityMapper {

    @Override
    public CityDto cityToCityDto(City city) {
        if ( city == null ) {
            return null;
        }

        CityDtoBuilder cityDto = CityDto.builder();

        cityDto.id( city.getId() );
        cityDto.lastUpdate( city.getLastUpdate() );
        cityDto.cityName( city.getCityName() );

        return cityDto.build();
    }

    @Override
    public City cityDtoToCity(CityDto city) {
        if ( city == null ) {
            return null;
        }

        CityBuilder city1 = City.builder();

        city1.id( city.getId() );
        city1.lastUpdate( city.getLastUpdate() );
        city1.cityName( city.getCityName() );

        return city1.build();
    }
}
