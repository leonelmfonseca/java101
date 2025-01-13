package com.leonelfonseca.java.appcontext;

import com.leonelfonseca.java.appcontext.model.Transportation;
import com.leonelfonseca.java.appcontext.config.TransportionConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TransportationMain {
  public static void main(String[] args) {

    Transportation transportation = new Transportation();

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