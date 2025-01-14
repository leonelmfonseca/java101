package com.leonelfonseca.java.di.wired.beanmultiplechoice.parameterinj;

import com.leonelfonseca.java.di.wired.beanmultiplechoice.parameterinj.config.ParameterInjectionMultipleBeansWiringConfig;
import com.leonelfonseca.java.di.wired.beanmultiplechoice.qualifier.model.Person;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DiParameterInjectionMultipleBeansWiringApplication {

  public static void main(String[] args) {

    System.out.println("Wire beans by direct method call");
    System.out.println();
    directMethodMultipleBeansWiring();
    System.out.println();
  }

  private static void directMethodMultipleBeansWiring() {

    var context =
        new AnnotationConfigApplicationContext(ParameterInjectionMultipleBeansWiringConfig.class);

    Person johnny = context.getBean(Person.class);

    System.out.println(johnny);
  }
}
