package com.test.modulith.order;

import com.test.modulith.event.OrderCompletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final ApplicationEventPublisher eventPublisher;

    public void placeOrder(String product) {
        System.out.println("✅ 주문 접수됨: " + product);
        eventPublisher.publishEvent(new OrderCompletedEvent(product));
    }
}
