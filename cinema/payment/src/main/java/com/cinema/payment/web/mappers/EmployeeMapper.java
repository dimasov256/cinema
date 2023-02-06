package com.cinema.payment.web.mappers;


import com.cinema.clients.payment.EmployeeDto;
import com.cinema.payment.domain.Employee;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper
@DecoratedWith(EmployeeMapperDecorator.class)
public interface EmployeeMapper {

    EmployeeDto employeeToEmployeeDto(Employee employee);

    Employee employeeDtoToEmployee(EmployeeDto employeeDto);
}
