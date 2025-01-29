package com.developer.java.ioc_with_spring.config;

import com.developer.java.ioc_with_spring.Car;
import com.developer.java.ioc_with_spring.Engine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
  @Bean
  public Engine engine() {
    return new Engine();
  }

  @Bean
  public Car car() {
    return new Car(engine());
  }
}
