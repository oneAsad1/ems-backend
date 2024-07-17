package com.oneasad.ems.mapper;

import com.oneasad.ems.dto.EmployeeDTO;
import com.oneasad.ems.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDTO mapToEmployeeDTO(Employee emp) {
        return new EmployeeDTO(
                emp.getId(),
                emp.getFirstName(),
                emp.getLastName(),
                emp.getEmail()
        );
    }
    public static Employee mapToEmployee(EmployeeDTO dto) {
        return new Employee(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail()
        );
    }
}
