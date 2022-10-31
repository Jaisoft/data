package com.jaisoft.data.jdbc.domain.entity;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class ProductEntity {
    private final UUID id;
    private final BigDecimal price;
    private final String name;
    
    public ProductEntity( final UUID id, final BigDecimal price, final String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity product = (ProductEntity) o;
        return Objects.equals(id, product.id) && Objects.equals(price, product.price) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, name);
    }
    
}
