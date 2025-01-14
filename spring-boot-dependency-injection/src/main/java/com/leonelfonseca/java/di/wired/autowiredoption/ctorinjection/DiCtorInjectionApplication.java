package com.leonelfonseca.java.di.wired.autowiredoption.ctorinjection;

import com.leonelfonseca.java.di.wired.autowiredoption.ctorinjection.component.Person;
import com.leonelfonseca.java.di.wired.autowiredoption.ctorinjection.config.CtorInjectionConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DiCtorInjectionApplication {

  public static void main(String[] args) {

    System.out.println("Constructor Injection");
    System.out.println();
    ctorInjectionDemo();
  }

  private static void ctorInjectionDemo() {

    /** Context instantiate beans based on configuration class */
    var context = new AnnotationConfigApplicationContext(CtorInjectionConfig.class);

    /** Bean are available to be used */
    Person johnny = context.getBean(Person.class);

    System.out.println(johnny);
  }
}
