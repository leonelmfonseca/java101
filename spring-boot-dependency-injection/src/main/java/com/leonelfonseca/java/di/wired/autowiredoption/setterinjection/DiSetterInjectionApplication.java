package com.leonelfonseca.java.di.wired.autowiredoption.setterinjection;

import com.leonelfonseca.java.di.wired.autowiredoption.setterinjection.component.Person;
import com.leonelfonseca.java.di.wired.autowiredoption.setterinjection.config.SetterInjectionConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DiSetterInjectionApplication {

  public static void main(String[] args) {

    System.out.println("Setter Injection");
    System.out.println();
    setterInjectionDemo();
  }

  private static void setterInjectionDemo() {

    /** Context instantiate beans based on configuration class */
    var context = new AnnotationConfigApplicationContext(SetterInjectionConfig.class);

    /** Bean are available to be used */
    Person johnny = context.getBean(Person.class);

    System.out.println(johnny);
  }
}
