package com.developer.java.ioc_with_di;


public class IoCDependencyInjection {

  public static void main(String[] args) {

    System.out.println("IoC with Dependency Injection Approach:");
    Engine engine = new Engine();
    System.out.println("Using dependency injection, the Car class receives the Engine instance from an external source.");
    System.out.println();
    Car car = new Car(engine);
    car.start();
  }
}
