package com.cinema.payment.web.mappers;

import com.cinema.clients.payment.EmployeeDto;
import com.cinema.clients.payment.ServiceDataDto;
import com.cinema.clients.payment.ServiceDataDto.ServiceDataDtoBuilder;
import com.cinema.payment.domain.Employee;
import com.cinema.payment.domain.Employee.EmployeeBuilder;
import com.cinema.payment.domain.ServiceData;
import java.sql.Timestamp;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-15T02:45:00+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
@Qualifier("delegate")
public class ServiceDataMapperImpl_ implements ServiceDataMapper {

    @Override
    public ServiceDataDto serviceDataToServiceDataDto(ServiceData serviceData) {
        if ( serviceData == null ) {
            return null;
        }

        ServiceDataDtoBuilder serviceDataDto = ServiceDataDto.builder();

        serviceDataDto.id( serviceData.getId() );
        serviceDataDto.lastUpdate( serviceData.getLastUpdate() );

        return serviceDataDto.build();
    }

    @Override
    public ServiceData serviceDataDtoToServiceData(ServiceDataDto serviceDataDto) {
        if ( serviceDataDto == null ) {
            return null;
        }

        Long id = null;
        Timestamp lastUpdate = null;

        id = serviceDataDto.getId();
        lastUpdate = serviceDataDto.getLastUpdate();

        ServiceData serviceData = new ServiceData( id, lastUpdate );

        serviceData.setEmployee( employeeDtoToEmployee( serviceDataDto.getEmployee() ) );

        return serviceData;
    }

    protected Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        EmployeeBuilder employee = Employee.builder();

        employee.id( employeeDto.getId() );
        employee.lastUpdate( employeeDto.getLastUpdate() );
        employee.user_id( employeeDto.getUser_id() );
        employee.userName( employeeDto.getUserName() );
        employee.amountAvailable( employeeDto.getAmountAvailable() );
        employee.amountReserved( employeeDto.getAmountReserved() );

        return employee.build();
    }
}
