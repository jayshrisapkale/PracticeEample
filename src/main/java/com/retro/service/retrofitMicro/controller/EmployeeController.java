package com.retro.service.retrofitMicro.controller;





import com.retro.service.retrofitMicro.dto.Employee;

import com.retro.service.retrofitMicro.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;
   @PostMapping("insertUser")
   public Employee insert(@RequestBody Employee user) throws IOException {
       return employeeService.insertEmployee(user);
   }

    @GetMapping("getById/{id}")
    public Employee getUserById(@PathVariable int id) throws IOException {
        return employeeService.getUser(id);
    }
@GetMapping("getAllEmployee")
    public List<Employee> getAll() throws IOException {
       return employeeService.getAllEmployee();
}
@DeleteMapping("deleteById/{id}")
    public String deleteById(@PathVariable int id) throws IOException{
       return employeeService.deleteById(id);
}
}
