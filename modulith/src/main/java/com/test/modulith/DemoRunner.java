package com.test.modulith;

import com.test.modulith.order.OrderService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoRunner {

    @Bean
    ApplicationRunner run(OrderService orderService) {
        return args -> {
            orderService.placeOrder("SpringBoot T-Shirt");
        };
    }
}
