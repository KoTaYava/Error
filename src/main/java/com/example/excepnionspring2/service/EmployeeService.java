package com.example.excepnionspring2.service;

import com.example.excepnionspring2.model.Employee;

import java.util.Collection;
import java.util.Optional;


public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int salary, int department);

    Employee findEmployee(String firstName, String lastName);

    Employee add(String firstName, String lastName, int salary, int department);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);

    Collection<Employee> findAllEmploee();

    Optional<Collection<Employee>> findAllEmployees();

    Employee removeEmployee(String firstName, String lastName);
}







