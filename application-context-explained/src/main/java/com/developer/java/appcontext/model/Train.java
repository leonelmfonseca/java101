package com.developer.java.appcontext.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Train {
    private String id;
    private String name;
    private int capacity;
    private double speed; // in km/h

    // Default constructor
    public Train() {
    }

    // Parameterized constructor
    public Train(String id, String name, int capacity, double speed) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.speed = speed;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    @Override
    public String toString() {
        return "Train{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", speed=" + speed +
                '}';
    }
}
