package com.example.excepnionspring2.controller;

import com.example.excepnionspring2.model.Employee;
import com.example.excepnionspring2.service.EmployeeService;
import com.example.excepnionspring2.service.EmployeeServiceimpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@RequestMapping("/employees")
public class EmployeeController extends EmployeeServiceimpl {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName)
    {
        return employeeService.add(firstName, lastName);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName)
    {
        return employeeService.remove(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName)
    {
        return employeeService.find(firstName, lastName);
    }

}