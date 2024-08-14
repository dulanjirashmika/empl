package com.company.empmgmtsystem.service;

import com.company.empmgmtsystem.model.Employee;
import com.company.empmgmtsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired  //Automatically initialising (Dependency injection - spring beans)
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll(); //The method we connected through JPA
    }

    public Employee saveEmployee(Employee employee){

        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.getReferenceById(id);
    }

    /*
    employeeDetails - New details of the employee
     */
    public Employee updateEmployeeById(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.getReferenceById(id);    //Already existing employee

        if(employee != null) {
            employee.setEmail(employeeDetails.getEmail());
            employee.setName(employeeDetails.getName());
            employee.setPosition(employeeDetails.getPosition());
            employee.setSalary(employeeDetails.getSalary());

            return employeeRepository.save(employee);
        } else {
            return null;
        }
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}