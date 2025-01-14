package com.developer.java.traditional_approach;

public class Car {

    private final Engine engine;

    public Car() {

        this.engine = new Engine();
        System.out.println("Car class creates an instance of the Engine class, leading to tight coupling.");
        System.out.println();
    }

    public void start(){
        this.engine.start();
        System.out.println("Car started");
    }

}
