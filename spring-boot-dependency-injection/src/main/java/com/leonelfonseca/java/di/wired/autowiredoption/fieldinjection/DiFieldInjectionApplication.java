package com.leonelfonseca.java.di.wired.autowiredoption.fieldinjection;

import com.leonelfonseca.java.di.wired.autowiredoption.fieldinjection.component.Person;
import com.leonelfonseca.java.di.wired.autowiredoption.fieldinjection.config.FieldInjectionConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DiFieldInjectionApplication {

  public static void main(String[] args) {

    System.out.println("Field Injection");
    System.out.println();
    fieldInjectionDemo();
  }

  private static void fieldInjectionDemo() {

    /** Context instantiate beans based on configuration class */
    var context = new AnnotationConfigApplicationContext(FieldInjectionConfig.class);

    /** Bean are available to be used */
    Person johnny = context.getBean(Person.class);

    System.out.println(johnny);
  }
}
