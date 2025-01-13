package com.leonelfonseca.java.appcontext.model;

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

    // Getter and Setter for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for capacity
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Getter and Setter for speed
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
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
