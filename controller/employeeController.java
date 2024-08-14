package com.company.empmgmtsystem.controller;

import com.company.empmgmtsystem.model.Employee;
import com.company.empmgmtsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")  //this is how to put base url
public class employeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public List<Employee> getAllEmployeesById(@PathVariable Long id){
        return employeeService.getEmployees();
    }

    @PostMapping("/add")
    public Employee createEmployee(@RequestBody Employee employee){

        return employeeService.saveEmployee(employee);


    }

    @PutMapping("/update/{id}")
    public Employee updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee){

        return employeeService.updateEmployeeById(id, employee);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);

    }
}
