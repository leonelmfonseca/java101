package com.leonelfonseca.java.appcontext.model;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/*
 *  With stereotype annotations, you add the annotation above the class for which you
 * need to have an instance in the Spring context.
 *  When doing so, we say that you’ve  marked the class as a component.
 * It tells Spring to create an instance of this class and add it to its context.
 *  But unlike using the @Bean annotation,
 * you don’t have full control over the instance creation.
 */
@Component
public class Car {
    private String model;
    private String manufacturer;
    private int year;
    private double price; // in USD

    // Default constructor
    public Car() {
    }

    // Parameterized constructor
    public Car(String model, String manufacturer, int year, double price) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.price = price;
    }

    /*
     * If we want to execute some instructions right after Spring creates the bean,
     * we can use the @PostConstruct annotation.
     * You just need to define a method in the component class and annotate
     * that method with @PostConstruct, which instructs Spring to call that
     * method after the constructor finishes its execution.
     */

    @PostConstruct
    public void init() {
        this.model = "2CV";
        this.manufacturer = "Citroën";
        this.year = 1948;
        this.price = 100000;
    }

    // Getter and Setter for model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Getter and Setter for manufacturer
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    // Getter and Setter for year
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Getter and Setter for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
