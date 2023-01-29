package com.cinema.payment.web.mappers;

import com.cinema.clients.payment.EmployeeDto;
import com.cinema.clients.payment.EmployeeDto.EmployeeDtoBuilder;
import com.cinema.payment.domain.Employee;
import java.sql.Timestamp;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-29T12:45:02+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
@Qualifier("delegate")
public class EmployeeMapperImpl_ implements EmployeeMapper {

    @Override
    public EmployeeDto employeeToEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDtoBuilder employeeDto = EmployeeDto.builder();

        employeeDto.id( employee.getId() );
        employeeDto.lastUpdate( employee.getLastUpdate() );
        employeeDto.user_id( employee.getUser_id() );

        return employeeDto.build();
    }

    @Override
    public Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Long id = null;
        Timestamp lastUpdate = null;
        Long user_id = null;

        id = employeeDto.getId();
        lastUpdate = employeeDto.getLastUpdate();
        user_id = employeeDto.getUser_id();

        Employee employee = new Employee( id, lastUpdate, user_id );

        return employee;
    }
}