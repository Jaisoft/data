package com.jaisoft.data.jdbc.integration.repository.jdbc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringOrderRepository extends CrudRepository<OrderAggregateJDBC, Long> {

}

