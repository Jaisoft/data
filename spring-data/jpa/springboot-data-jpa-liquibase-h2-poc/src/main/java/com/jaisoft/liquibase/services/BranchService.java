package com.jaisoft.liquibase.services;

import com.jaisoft.liquibase.entities.Branch;

import java.util.stream.Stream;

public interface BranchService {
    Stream<Branch> getCompanies();
}
