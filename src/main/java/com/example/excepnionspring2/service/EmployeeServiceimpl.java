package com.example.excepnionspring2.service;

import com.example.excepnionspring2.exception.EmployeeAlreadyAddedException;
import com.example.excepnionspring2.exception.EmployeeNotFoundException;
import com.example.excepnionspring2.exception.EmployeeStoragelsFullException;
import com.example.excepnionspring2.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceimpl implements EmployeeService {
    private final int maxSize = 10;

    private final List<Employee> employees = new ArrayList<>();

    @Override
    public Employee add(String firstName, String lastName) {
        if (employees.size() >= maxSize) {
            throw new EmployeeStoragelsFullException("Достигнуто максимальное количество!");
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник " + firstName + " " + lastName + " уже имеется!");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник " + firstName + " " + lastName + " не найден.");
        }
        employees.remove(employee);
        return employee;
    }



    @Override
    public Employee find(String firstName, String lastName) {
        Employee person = new Employee(firstName, lastName);
        for (Employee employee : employees) {
            if (employees.equals(person)) {
                return person;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник " + firstName + " " + lastName + " не найден.");
    }

}