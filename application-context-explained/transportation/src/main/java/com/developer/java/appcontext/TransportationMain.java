package com.developer.java.appcontext;

import com.developer.java.appcontext.config.TransportionConfig;
import com.developer.java.appcontext.model.Transportation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TransportationMain {
  public static void main(String[] args) {

    // This is an empty context
    var context = new AnnotationConfigApplicationContext(
            TransportionConfig.class);

    // Gets a reference of a bean of type Transportation from the Spring context
    Transportation t = context.getBean(Transportation.class);

    String s = context.getBean(String.class);
    System.out.println(s);

    Integer n = context.getBean(Integer.class);
    System.out.println(n);


    System.out.println(t.getType());
  }
}