package com.example.demo.config;

import com.example.demo.service.MBWayService;
import com.example.demo.service.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfiguration {

    @Bean
    public PaymentService paymentService() {
            return new MBWayService();
    }

}
