package com.leonelfonseca.java.di.wired.beanmultiplechoice.qualifier;

import com.leonelfonseca.java.di.wired.beanmultiplechoice.qualifier.config.QualifierAnnotMultipleBeansWiringConfig;
import com.leonelfonseca.java.di.wired.beanmultiplechoice.qualifier.model.Person;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DiQualifierMultipleBeansWiringApplication {

  public static void main(String[] args) {

    System.out.println("Wire beans using @Qualifier annotation");
    System.out.println(
        "This wiring approach is the best practice, as developer explicits his intention");
    System.out.println();
    qualifierAnnotMultipleBeansWiring();
    System.out.println();
  }

  private static void qualifierAnnotMultipleBeansWiring() {

    var context =
        new AnnotationConfigApplicationContext(QualifierAnnotMultipleBeansWiringConfig.class);

    Person johnny = context.getBean(Person.class);

    System.out.println(johnny);
  }
}
