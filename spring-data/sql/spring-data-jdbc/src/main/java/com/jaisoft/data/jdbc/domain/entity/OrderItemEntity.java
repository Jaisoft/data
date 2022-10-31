package com.jaisoft.data.jdbc.domain.entity;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class OrderItemEntity {
    private UUID productId;
    private BigDecimal price;

    public OrderItemEntity(final ProductEntity product) {
        this.productId = product.getId();
        this.price = product.getPrice();
    }

    public UUID getProductId() {
        return productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    private OrderItemEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemEntity orderItem = (OrderItemEntity) o;
        return Objects.equals(productId, orderItem.productId) && Objects.equals(price, orderItem.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, price);
    }
}