package com.example.test.service.impl;

import com.example.test.entity.Employee;
import com.example.test.exception.ResourceNotFoundException;
import com.example.test.repository.EmployeeRepository;
import com.example.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll().stream().map(
              employee ->Employee.builder()
                      .id(employee.getId())
                      .name(employee.getName())
                      .position(employee.getPosition())
                      .email(employee.getEmail())
                      .salary(employee.getSalary())
                      .build()
        ).collect(Collectors.toList());
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id , Employee employee) {

        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));

        Employee newEmp = Employee.builder()
                .id(id)
                .name(employee.getName())
                .position(employee.getPosition())
                .email(employee.getEmail())
                .salary(employee.getSalary())
                .build();

        repository.save(newEmp);

        return newEmp;
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));

        repository.deleteById(id);
    }
}
