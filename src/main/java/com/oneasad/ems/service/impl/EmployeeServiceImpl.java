package com.oneasad.ems.service.impl;

import com.oneasad.ems.dto.EmployeeDTO;
import com.oneasad.ems.entity.Employee;
import com.oneasad.ems.exception.ResourceNotFoundException;
import com.oneasad.ems.mapper.EmployeeMapper;
import com.oneasad.ems.repository.EmployeeRepository;
import com.oneasad.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    public EmployeeDTO getEmployeeById(Long empId) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exists with this empId: " + empId));
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO updateEmployee(Long empId, EmployeeDTO updatedEmployeeDTO) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exists with this empId: " + empId)
        );
        employee.setFirstName(updatedEmployeeDTO.getFirstName());
        employee.setLastName(updatedEmployeeDTO.getLastName());
        employee.setEmail(updatedEmployeeDTO.getEmail());
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    public void deleteEmployee(Long empId) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exists with this empId: " + empId)
        );
        employeeRepository.delete(employee);
    }
}
