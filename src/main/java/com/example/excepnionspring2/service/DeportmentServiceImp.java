package com.example.excepnionspring2.service;

import com.example.excepnionspring2.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeportmentServiceImp implements DepartmentService {
    private EmployeeService employeeService;
    public void DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Optional<Employee> findEmployeeMinSalaryByDepartment(int department) {
        return employeeService.findAllEmployees().stream()
                .filter(employee -> employee.getDepartment()==department)
                .min(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public Optional<Employee> findEmployeeMaxSalaryByDepartment(int department) {
        return employeeService.findAllEmployees().stream()
                .filter(employee -> employee.getDepartment()==department)
                .max(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public List<Employee> allEmployeesByDepartment(int department) {
        return employeeService.findAllEmployees().stream()
                .filter(employee -> employee.getDepartment()==department).toList()
                ;
    }

    @Override
    public Object findAll() {
        return employeeService.findAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
