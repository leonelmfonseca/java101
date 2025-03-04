package com.developer.java.appcontext;

import com.developer.java.appcontext.config.CarConfig;
import com.developer.java.appcontext.model.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarStereotypeAnnotationMain {
  public static void main(String[] args) {

    var context = new AnnotationConfigApplicationContext(CarConfig.class);

    // This way, you can only add one instance of the class to the context.
    // Stereotype annotations only to create beans of the classes your application owns.
    Car myCar = context.getBean(Car.class);
    System.out.println(myCar);
  }
}
