package com.jaisoft.liquibase.services;

import com.jaisoft.liquibase.entities.Employee;
import com.jaisoft.liquibase.repositories.EmployeeRepository;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeesRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Override
    public Stream<Employee> getAllEmployees() {
        return StreamSupport.stream(employeesRepository.findAll().spliterator(), true);
    }
}
