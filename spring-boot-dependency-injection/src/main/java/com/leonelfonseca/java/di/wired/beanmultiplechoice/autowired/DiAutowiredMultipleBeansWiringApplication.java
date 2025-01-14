package com.leonelfonseca.java.di.wired.beanmultiplechoice.autowired;

import com.leonelfonseca.java.di.wired.beanmultiplechoice.autowired.config.AutowiredMultipleBeansWiringConfig;
import com.leonelfonseca.java.di.wired.beanmultiplechoice.autowired.model.Person;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DiAutowiredMultipleBeansWiringApplication {

  public static void main(String[] args) {

    System.out.println("Wire beans autowiring");
    System.out.println();
    autowiredMultipleBeansWiring();
    System.out.println();
  }

  private static void autowiredMultipleBeansWiring() {

    var context = new AnnotationConfigApplicationContext(AutowiredMultipleBeansWiringConfig.class);

    Person johnny = context.getBean(Person.class);

    System.out.println(johnny);
  }
}
