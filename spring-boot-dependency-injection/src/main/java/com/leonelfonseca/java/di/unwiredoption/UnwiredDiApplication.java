package com.leonelfonseca.java.di.unwiredoption;

import com.leonelfonseca.java.di.unwiredoption.config.UnwiredBeansConfig;
import com.leonelfonseca.java.di.unwiredoption.model.Cat;
import com.leonelfonseca.java.di.unwiredoption.model.Person;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class UnwiredDiApplication {

  public static void main(String[] args) {

    System.out.println("Unwired Beans");
    System.out.println();
    unwiredBeansDemo();
  }

  private static void unwiredBeansDemo() {

    /** Context instantiate beans based on configuration class */
    var context = new AnnotationConfigApplicationContext(UnwiredBeansConfig.class);

    /** Beans are available to be used */
    Person johnny = context.getBean(Person.class);
    Cat mittens = context.getBean(Cat.class);

    /**
     * Johnny and Mittens are in the context, however, observe that johnnies "mittens" is null,
     * which mean that there’s not yet a relationship between the instances
     */
    System.out.println(johnny);

    System.out.println(mittens);
  }
}
