package com.developer.java.ioc_with_springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IoCWithSpringBoot {

  public static void main(String[] args) {
    SpringApplication.run(IoCWithSpringBoot.class, args);
  }

  @Bean
  public CommandLineRunner run(Car car) {
    return args -> {
      System.out.println("IoC with Spring Boot Approach:");
      System.out.println("""
              Spring Boot manages IoC using dependency injection, \
              provides auto-configuration, which eliminates the need for explicit configuration(in most cases),\s
              and it automatically configures your application based on the dependencies present in your project, allowing for cleaner, more modular code.""");
      System.out.println();
      car.start();
    };
  }
}
