package com.example.ioc_with_di;

public class Car {

    private final Engine engine;

    public Car(Engine engine) {

        this.engine = engine;
    }

    public void start(){
        this.engine.start();
        System.out.println("Car started");
    }

}
