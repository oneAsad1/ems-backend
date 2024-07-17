package com.oneasad.ems.service;

import com.oneasad.ems.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Long empId);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO updateEmployee(Long empId, EmployeeDTO updatedEmployeeDTO);
    void deleteEmployee(Long empId);
}
