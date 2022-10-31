package com.jaisoft.data.jdbc.integration.repository.jdbc;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.jaisoft.data.jdbc.domain.aggregate.OrderAggregate;
import com.jaisoft.data.jdbc.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
@Component
public class ImplOrderRepositoy implements OrderRepository {
    


    private final SpringOrderRepository orderRepository;

    @Autowired
    public ImplOrderRepositoy(SpringOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<OrderAggregate> findById(UUID id) {
        Optional<OrderAggregateJDBC> orderEntity = orderRepository.findById(id);
        if (orderEntity.isPresent()) {
            return Optional.of(orderEntity.get()
                .toOrder());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void save(Order order) {
        orderRepository.save(new OrderEntity(order));
    }
}
