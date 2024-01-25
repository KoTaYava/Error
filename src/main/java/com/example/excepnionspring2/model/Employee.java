package com.example.excepnionspring2.model;

import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Objects;

import static org.apache.tomcat.util.IntrospectionUtils.capitalize;

public class Employee {

        private final String firstName;
        private final String lastName;
        private static int salary;
        private static int department;

        public Employee(String firstName, String lastName, int salary, int department) {
                this.firstName = StringUtils.capitalize(firstName.toLowerCase());
                this.lastName = StringUtils.capitalize(lastName.toLowerCase());
                this.department = department;
                this.salary = salary;
        }

        public Employee(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
        }

        public static int getDepartment() {
                return department;
        }

        public static int getSalary() {
                return salary;
        }

        public String getFirstName() {
                return firstName;
        }

        public String getLastName() {
                return lastName;
        }


        @Override
        public String toString() {
                return "Employee{" +
                        "firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", department=" + department +
                        ", salary=" + salary +
                        '}';
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Employee employee = (Employee) o;
                return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
        }

        @Override
        public int hashCode() {
                return Objects.hash(firstName, lastName);
        }


        public static int getSalary(Collection<Employee> employees) {
                return salary;
        }

        }



