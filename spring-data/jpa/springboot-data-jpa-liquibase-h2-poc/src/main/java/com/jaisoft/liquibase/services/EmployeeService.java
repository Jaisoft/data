package com.jaisoft.liquibase.services;

import com.jaisoft.liquibase.entities.Employee;

import java.util.stream.Stream;

public interface EmployeeService {
    Stream<Employee> getAllEmployees();
}
