package com.test.transaction.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
@Entity
public class Order {

    @Id
    private Long id;

    private Long productId;

    private int quantity;

    private BigDecimal totalPrice;

    public void updateTotalPrice(BigDecimal productPrice) {
        if (productPrice == null || quantity <= 0) {
            throw new IllegalArgumentException("Product price cannot be null and quantity must be greater than zero.");
        }
        this.totalPrice = productPrice.multiply(BigDecimal.valueOf(quantity));
    }
}
