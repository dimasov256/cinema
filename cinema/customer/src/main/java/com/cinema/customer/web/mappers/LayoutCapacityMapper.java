package com.cinema.customer.web.mappers;

import com.cinema.customer.domain.LayoutCapacity;
import com.cinema.clients.customer.model.LayoutCapacityDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper
@DecoratedWith(LayoutCapacityDecorator.class)
public interface LayoutCapacityMapper {

    LayoutCapacityDto layoutCapacityToLayoutCapacityDto(LayoutCapacity layoutCapacity);

    LayoutCapacity layoutCapacityDtoToLayoutCapacity(LayoutCapacityDto layoutCapacityDto);
}
