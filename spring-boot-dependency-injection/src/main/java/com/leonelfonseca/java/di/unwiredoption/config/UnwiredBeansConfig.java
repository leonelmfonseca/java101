package com.leonelfonseca.java.di.unwiredoption.config;

import com.leonelfonseca.java.di.unwiredoption.model.Cat;
import com.leonelfonseca.java.di.unwiredoption.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnwiredBeansConfig {

  @Bean
  public Cat cat() {
    Cat c = new Cat();
    c.setAge(3);
    c.setName("Mittens");
    c.setColor("brown");
    c.setBreed("Siamese");
    c.setWeight(7d);

    return c;
  }

  @Bean
  Person person() {
    Person p = new Person();
    p.setAge(23);
    p.setName("John Doe");

    return p;
  }
}
