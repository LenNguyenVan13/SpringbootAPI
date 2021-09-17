package com.example.springbootapi.controller;

import com.example.springbootapi.dto.EmployeeDTO;
import com.example.springbootapi.entity.Employee;
import com.example.springbootapi.error.EmployeeNotFoundException;
import com.example.springbootapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee saveEmployee(@Valid @RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) throws EmployeeNotFoundException {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();

        List<EmployeeDTO> dtoList = new ArrayList<>();
        for(Employee employee : employees){
            dtoList.add(new EmployeeDTO(employee));
        }
        return dtoList;
    }
    @DeleteMapping("/employees/{id}")
    public void deleteById(@PathVariable("id") Long id){
        employeeService.deleteById(id);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployeeById(@PathVariable("id") Long id,@RequestBody Employee employee){

        return employeeService.updateEmployeeById(id, employee);
    }

}
