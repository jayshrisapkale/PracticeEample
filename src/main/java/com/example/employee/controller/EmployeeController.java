package com.example.employee.controller;

import com.example.employee.entity.Employee;
import com.example.employee.exceptionhandling.ResourceNotFoundException;
import com.example.employee.service.EmployeeService;
import com.example.employee.service.EmployeeServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("insertUser")
    public Employee insertEmployee(@RequestBody Employee employee) {
        return employeeService.insertEmployee(employee);
    }

    @GetMapping("getById/{id}")
    public Employee getById(@PathVariable Long id) {

        return employeeService.getById(id);
    }
    @GetMapping("getAll")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }
    @DeleteMapping("deleteById/{id}")
    public String deleteByid(@PathVariable Long id){
       return employeeService.deleteById(id);
    }
}