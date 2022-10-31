package com.jaisoft.data.jdbc.integration.repository.jdbc;

import java.math.BigDecimal;
import java.util.List;

import com.jaisoft.data.jdbc.domain.entity.OrderItemEntity;

import com.jaisoft.data.jdbc.domain.vo.OrderStatusVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderAggregateJDBC {
        @Id
        private Long id;
        private OrderStatusVO status;
        private List<OrderItemEntity> orderItems;
        private BigDecimal price;

       
    
        
    
}
