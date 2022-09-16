package com.jaisoft.liquibase.repositories;

import com.jaisoft.liquibase.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
