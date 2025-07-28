package com.test.modulith.notification;

import com.test.modulith.event.OrderCompletedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @EventListener
    public void on(OrderCompletedEvent event) {
        System.out.println("📨 알림 전송됨: 주문 완료 - " + event.product());
    }
}
