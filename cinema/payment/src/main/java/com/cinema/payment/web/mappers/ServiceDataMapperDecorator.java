package com.cinema.payment.web.mappers;

import com.cinema.clients.payment.ServiceDataDto;
import com.cinema.payment.domain.ServiceData;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ServiceDataMapperDecorator implements ServiceDataMapper {

    private ServiceDataMapper serviceDataMapper;

    @Autowired
    public void setServiceDataMapper(ServiceDataMapper serviceDataMapper) {
        this.serviceDataMapper = serviceDataMapper;
    }

    @Override
    public ServiceDataDto serviceDataToServiceDataDto(ServiceData serviceData) {
        return serviceDataMapper.serviceDataToServiceDataDto(serviceData);
    }

    @Override
    public ServiceData serviceDataDtoToServiceData(ServiceDataDto serviceDataDto) {
        return serviceDataMapper.serviceDataDtoToServiceData(serviceDataDto);
    }
}
