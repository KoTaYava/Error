package com.example.excepnionspring2.service;

import com.example.excepnionspring2.model.Employee;


public interface EmployeeService {
    Employee add(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
}







