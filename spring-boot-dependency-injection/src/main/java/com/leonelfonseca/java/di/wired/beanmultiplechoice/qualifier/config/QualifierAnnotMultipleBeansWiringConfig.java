package com.leonelfonseca.java.di.wired.beanmultiplechoice.qualifier.config;

import com.leonelfonseca.java.di.wired.beanmultiplechoice.qualifier.model.Cat;
import com.leonelfonseca.java.di.wired.beanmultiplechoice.qualifier.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QualifierAnnotMultipleBeansWiringConfig {

  @Bean
  public Cat mittens() {
    Cat c = new Cat();
    c.setAge(3);
    c.setName("Mittens");
    c.setColor("brown");
    c.setBreed("Siamese");
    c.setWeight(7d);

    System.out.println(c.getName() + ": miau!");
    return c;
  }

  @Bean
  public Cat tiger() {
    Cat c = new Cat();
    c.setAge(1);
    c.setName("Tiger");
    c.setColor("white");
    c.setBreed("Japanese Bobtail");
    c.setWeight(4d);

    System.out.println(c.getName() + ": miau!");
    return c;
  }

  /**
   * Observe that instead of having a specific identifier of the parameter, it specifies the
   * bean we want to inject using the value attribute of the @Qualifier annotation.
   * Using @Qualifier annotation express intention to inject a specific bean.
   */
  @Bean
  Person person(@Qualifier("mittens") Cat cat) {

    Person p = new Person();
    p.setName("John Doe");
    p.setAge(22);
    p.setCat(cat);

    return p;
  }
}
