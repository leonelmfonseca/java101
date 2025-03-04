package com.developer.java.appcontext.beanambiguity.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transportation {
    private String type;        // Type of transportation (e.g., Car, Bus, Bike)
    private int capacity;       // Number of passengers it can carry
    private String fuelType;    // Type of fuel used (e.g., Gasoline, Electric)

    // Default constructor
    public Transportation() {
    }

    // Parameterized constructor
    public Transportation(String type, int capacity, String fuelType) {
        this.type = type;
        this.capacity = capacity;
        this.fuelType = fuelType;
    }

    // Getter for type
    public String getType() {
        return type;
    }

    // Setter for type
    public void setType(String type) {
        this.type = type;
    }

    // Getter for capacity
    public int getCapacity() {
        return capacity;
    }

    // Setter for capacity
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Getter for fuelType
    public String getFuelType() {
        return fuelType;
    }

    // Setter for fuelType
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "type='" + type + '\'' +
                ", capacity=" + capacity +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}