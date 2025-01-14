package com.developer.java.ioc_with_spring;

import com.developer.java.ioc_with_spring.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IoCWithSpring {

  public static void main(String[] args) {

    System.out.println("IoC with Spring Approach:");
    System.out.println("Implementing IoC using a framework like Spring, manages the dependencies automatically, \n" +
            "although it's necessary to manually set up the application context and specify beans and their dependencies.");
    System.out.println();
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    Car car = context.getBean(Car.class);
    car.start();
  }
}
