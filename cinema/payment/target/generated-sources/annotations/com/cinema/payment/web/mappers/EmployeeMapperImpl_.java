package com.cinema.payment.web.mappers;

import com.cinema.clients.payment.EmployeeDto;
import com.cinema.clients.payment.EmployeeDto.EmployeeDtoBuilder;
import com.cinema.payment.domain.Employee;
import com.cinema.payment.domain.Employee.EmployeeBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-01T14:40:09+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
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
        employeeDto.userName( employee.getUserName() );
        employeeDto.amountAvailable( employee.getAmountAvailable() );
        employeeDto.amountReserved( employee.getAmountReserved() );

        return employeeDto.build();
    }

    @Override
    public Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
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
