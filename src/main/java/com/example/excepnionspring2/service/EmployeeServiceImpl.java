package com.example.excepnionspring2.service;

import com.example.excepnionspring2.exception.EmployeeStoragelsFullException;
import com.example.excepnionspring2.model.Employee;
import com.example.excepnionspring2.exception.EmployeeAlreadyAddedException;
import com.example.excepnionspring2.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.tomcat.util.http.parser.HttpParser.isAlpha;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeeMap;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }
    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int department) {

        validateInput(firstName, lastName);

        if (employeeMap.containsKey(firstName + lastName)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
        }
        employeeMap.put((firstName + lastName),
                new Employee(firstName, lastName, salary, department));
        return employeeMap.get(firstName + lastName);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {

        validateInput(firstName, lastName);

        if (employeeMap.containsKey(firstName + lastName)) {
            return employeeMap.get(firstName + lastName);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
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

    @Override
    public Optional<Collection<Employee>> findAllEmployees() {
        return Optional.of(Collections.unmodifiableCollection(employeeMap.values()));
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {

        validateInput(firstName, lastName);

        employeeMap.remove(firstName + lastName);
        return new Employee(firstName,lastName);
    }

    private void validateInput(String firsName, String lastName) {
        if(!(isAlpha(Integer.parseInt(firsName))&&isAlpha(Integer.parseInt(lastName)))){
            throw new EmployeeStoragelsFullException("incorrect name or surname");
        }
    }
}