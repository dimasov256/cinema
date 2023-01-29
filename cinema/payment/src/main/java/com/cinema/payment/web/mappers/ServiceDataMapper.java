package com.cinema.payment.web.mappers;

import com.cinema.clients.payment.ServiceDataDto;
import com.cinema.payment.domain.ServiceData;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper
@DecoratedWith(ServiceDataMapperDecorator.class)
public interface ServiceDataMapper {

    ServiceDataDto serviceDataToServiceDataDto(ServiceData serviceData);

    ServiceData serviceDataDtoToServiceData(ServiceDataDto serviceDataDto);
}
