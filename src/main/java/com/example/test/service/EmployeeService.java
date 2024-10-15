package com.example.test.service;

import com.example.test.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(Long id);

    public Employee createEmployee(Employee employee);

    public Employee updateEmployee(Long id,Employee employee);

    public void deleteEmployee(Long id);
}
