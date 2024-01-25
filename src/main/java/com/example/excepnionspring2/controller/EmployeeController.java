package com.example.excepnionspring2.controller;

import com.example.excepnionspring2.model.Employee;
import com.example.excepnionspring2.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController implements EmployeeService {
    ///departments/max-salary?departmentId=5
    private EmployeeService employeeService;


    @ExceptionHandler
    public ResponseEntity<String> handleEmployeeException(RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("salary") int salary,
                                @RequestParam("department") int department) {
        return employeeService.add(firstName, lastName, salary, department);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int department) {
        return null;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        return null;
    }

    @Override
    public Collection<Employee> findAllEmploee() {
        return null;
    }

    @GetMapping
    public Optional<Collection<Employee>> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

}