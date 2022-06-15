package com.example.employee.service;

import com.example.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee insertEmployee(Employee employee);

    Employee getById(Long id);

    List<Employee> getAll();

    String deleteById(Long id);
}
