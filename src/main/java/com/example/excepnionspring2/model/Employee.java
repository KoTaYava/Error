package com.example.excepnionspring2.model;

import java.util.Objects;



public class Employee {
    private final String firstMame;
    private final String lastName;

    public Employee(String firstMame, String lastName) {
        this.firstMame = firstMame;
        this.lastName = lastName;
    }

    public String getFirstMame() {
        return firstMame;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getFirstMame(), employee.getFirstMame()) && Objects.equals(getLastName(), employee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstMame(), getLastName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstMame='" + firstMame + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}