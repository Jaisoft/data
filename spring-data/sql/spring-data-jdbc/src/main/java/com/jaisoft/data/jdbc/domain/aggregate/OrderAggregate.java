package com.jaisoft.data.jdbc.domain.aggregate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


import com.jaisoft.data.jdbc.domain.entity.OrderItemEntity;
import com.jaisoft.data.jdbc.domain.entity.ProductEntity;
import com.jaisoft.data.jdbc.domain.entity.DomainException;
import com.jaisoft.data.jdbc.domain.vo.OrderStatusVO;

public class OrderAggregate {

   
        private Long id;
        private OrderStatusVO status;
        private List<OrderItemEntity> orderItems;
        private BigDecimal price;

        private OrderAggregate() {
        }
    
        public OrderAggregate(final Long id, final ProductEntity product) {
            this.id = id;
            this.orderItems = new ArrayList<>(Collections.singletonList(new OrderItemEntity(product)));
            this.status = OrderStatusVO.CREATED;
            this.price = product.getPrice();
        }
    
        public void complete() {
            validateState();
            this.status = OrderStatusVO.COMPLETED;
        }
    
        public void addOrder(final ProductEntity product) {
            validateState();
            validateProduct(product);
            orderItems.add(new OrderItemEntity(product));
            price = price.add(product.getPrice());
        }
    
        public void removeOrder(final Long id) {
            validateState();
            final OrderItemEntity orderItem = getOrderItem(id);
            orderItems.remove(orderItem);
    
            price = price.subtract(orderItem.getPrice());
        }
    
        private OrderItemEntity getOrderItem(final Long id) {
            return orderItems.stream()
                .filter(orderItem -> orderItem.getProductId()
                    .equals(id))
                .findFirst()
                .orElseThrow(() -> new DomainException("Product with " + id + " doesn't exist."));
        }
    
        private void validateState() {
            if (OrderStatusVO.COMPLETED.equals(status)) {
                throw new DomainException("The order is in completed state.");
            }
        }
    
        private void validateProduct(final ProductEntity product) {
            if (product == null) {
                throw new DomainException("The product cannot be null.");
            }
        }
    
        public Long getId() {
            return id;
        }
    
        public OrderStatusVO getStatus() {
            return status;
        }
    
        public BigDecimal getPrice() {
            return price;
        }
    
        public List<OrderItemEntity> getOrderItems() {
            return Collections.unmodifiableList(orderItems);
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(id, orderItems, price, status);
        }
    
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof OrderAggregate))
                return false;
                OrderAggregate other = (OrderAggregate) obj;
            return Objects.equals(id, other.id) && Objects.equals(orderItems, other.orderItems) && Objects.equals(price, other.price) && status == other.status;
        }
    
        
    
}
