package com.cinema.payment.web.mappers;

import com.cinema.clients.payment.EmployeeDto;
import com.cinema.payment.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class EmployeeMapperDecorator implements EmployeeMapper{

    private EmployeeMapper employeeMapper;

    @Autowired
    public void setEmployeeMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDto employeeToEmployeeDto(Employee employee) {
        return employeeMapper.employeeToEmployeeDto(employee);
    }

    @Override
    public Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
        return employeeMapper.employeeDtoToEmployee(employeeDto);
    }
}
