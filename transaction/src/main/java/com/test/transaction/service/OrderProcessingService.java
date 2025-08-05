package com.test.transaction.service;

import com.test.transaction.entity.Order;
import com.test.transaction.entity.Product;
import com.test.transaction.handler.InventoryHandler;
import com.test.transaction.handler.OrderHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderProcessingService {

    private final OrderHandler orderHandler;
    private final InventoryHandler inventoryHandler;

    @Transactional
    public Order placeOrder(Order order) {

        // get product inventory
        Product product = inventoryHandler.getProduct(order.getProductId());

        // validate stock availability (5)
        validateStockAvailability(order, product);

        // update total price in order entity
        order.updateTotalPrice(product.getPrice());

        // save order
        Order savedOrder = orderHandler.save(order);

        // update stock in inventory
        updateInventoryStock(order, product);

        return savedOrder;
    }

    private void validateStockAvailability(Order order, Product product) {
        if (order.getQuantity() > product.getStockQuantity()) {
            throw new RuntimeException("Insufficient stock for product: " + product.getName());
        }
    }

    private void updateInventoryStock(Order order, Product product) {
        product.updateStockQuantity(order.getQuantity());
        inventoryHandler.updateProductDetails(product);
    }

}
