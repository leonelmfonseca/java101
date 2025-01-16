package com.developer.java.appcontext.model;

import lombok.Getter;
import lombok.Setter;
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
@Getter
@Setter
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

    // Getter and Setter for DTO
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    @Override
    public String toString() {
        return "Car{" +
                "DTO='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
