package com.example.excepnionspring2.service;

import com.example.excepnionspring2.exception.Invalid;
import com.example.excepnionspring2.model.Employee;
import com.example.excepnionspring2.service.EmployeeService;
import com.example.excepnionspring2.exception.EmployeeAlreadyAddedException;
import com.example.excepnionspring2.exception.EmployeeNotFoundException;
import com.example.excepnionspring2.exception.InvalidInputException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
        valitadeInput(firstName, lastName);

        validateInput(firstName, lastName);

        if (employeeMap.containsKey(firstName + lastName)) {
            return employeeMap.get(firstName + lastName);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Collection<Employee> findAllEmployees() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        valitadeInput(firstName, lastName);

        validateInput(firstName, lastName);

        employeeMap.remove(firstName + lastName);
        return new Employee(firstName, lastName);
    }

    private void validateInput(String firsName, String lastName) {
        if (!(isAlpha(Integer.parseInt(firsName)) && isAlpha(Integer.parseInt(lastName)))) {
            throw new InvalidInputException("incorrect name or surname");
        }
    }

    private boolean valitadeInput(String firstName, String lastName) {
        if (!(StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName))) {
            throw new Invalid();
        }

        throw new Invalid();
    }

}
