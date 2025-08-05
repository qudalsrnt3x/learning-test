package com.test.transaction.handler;

import com.test.transaction.entity.Product;
import com.test.transaction.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InventoryHandler {

    private final InventoryRepository inventoryRepository;

    public Product updateProductDetails(Product product) {
        return inventoryRepository.save(product);
    }

    public Product getProduct(Long productId) {
        return inventoryRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
    }

}
