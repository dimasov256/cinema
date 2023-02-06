package com.cinema.customer.web.mappers;

import com.cinema.customer.domain.LayoutCapacity;
import com.cinema.clients.customer.model.LayoutCapacityDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class LayoutCapacityDecorator implements LayoutCapacityMapper {

    private LayoutCapacityMapper layoutCapacityMapper;

    @Autowired
    public void setLayoutCapacityMapper(LayoutCapacityMapper layoutCapacityMapper) {
        this.layoutCapacityMapper = layoutCapacityMapper;
    }

    @Override
    public LayoutCapacityDto layoutCapacityToLayoutCapacityDto(LayoutCapacity layoutCapacity) {
        return layoutCapacityMapper.layoutCapacityToLayoutCapacityDto(layoutCapacity);
    }

    @Override
    public LayoutCapacity layoutCapacityDtoToLayoutCapacity(LayoutCapacityDto layoutCapacityDto) {
        return layoutCapacityMapper.layoutCapacityDtoToLayoutCapacity(layoutCapacityDto);
    }
}
