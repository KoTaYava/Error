package com.example.excepnionspring2.service;

import com.example.excepnionspring2.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface DepartmentService {
    Optional<Employee> findEmployeeMinSalaryByDepartment(int department);

    Optional<Employee> findEmploeeMinSalaryByDepartment(int department);
    Optional<Employee> findEmployeeMaxSalaryByDepartment(int department);

    List<Employee> allEmployeesByDepartment(int department);

    Map<Integer, List<Employee>> findAll();
}