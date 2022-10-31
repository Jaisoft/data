package com.jaisoft.data.jdbc.domain.repository;

import java.util.Optional;
import java.util.UUID;
import com.jaisoft.data.jdbc.domain.aggregate.OrderAggregate;
public interface OrderRepository {

    Optional<OrderAggregate> findById(UUID id);

    void save(OrderAggregate order);
    
}
