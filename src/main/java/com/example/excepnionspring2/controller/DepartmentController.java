package com.example.excepnionspring2.controller;

import com.example.excepnionspring2.service.DepartmentService;
import com.example.excepnionspring2.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/min-salary")
    public Optional<Employee> minSalaryByDepartment(@RequestParam int department) {
        return departmentService.findEmployeeMinSalaryByDepartment(department);
    }

    @GetMapping("/max-salary")
    public Optional<Employee> maxSalaryByDepartment(@RequestParam int department) {
        return departmentService.findEmployeeMaxSalaryByDepartment(department);
    }

    @GetMapping("/all")
    public List<Employee> allEmployeesByDepartment(@RequestParam int department) {
        return departmentService.allEmployeesByDepartment(department);
    }

    @GetMapping
    public Collection<Employee> findAll(){
        return (Collection<Employee>) departmentService.findAll();
    }
}
