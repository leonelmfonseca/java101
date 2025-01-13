package com.example.ioc_with_spring.config;

import com.example.ioc_with_spring.Car;
import com.example.ioc_with_spring.Engine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Engine engine() { return new Engine(); } @Bean public Car car() { return new Car(engine()); }
}
