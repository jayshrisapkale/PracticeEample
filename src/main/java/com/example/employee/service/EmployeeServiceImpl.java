package com.example.employee.service;

import com.example.employee.entity.Employee;
import com.example.employee.exceptionhandling.ExceptionResponse;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee insertEmployee(Employee employee)  {
        if(employee.getName().isEmpty()|| employee.getName().length()==0){
            throw new ExceptionResponse("field is empty","601");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getById(Long id) {

        return employeeRepository.findById(id).get();
    }


    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public String deleteById(Long id) {
employeeRepository.deleteById(id);
return "employee deleted successfully";
    }
}
