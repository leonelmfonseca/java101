package com.leonelfonseca.java.di.wired.directmethodwiring.config;

import com.leonelfonseca.java.di.unwiredoption.model.Cat;
import com.leonelfonseca.java.di.unwiredoption.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectMethodWiringConfig {

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
    p.setName("John Doe");
    p.setAge(22);

    /**
     * We define the relationship between the person bean and the cat bean by directly calling the
     * method(direct wiring) that returns the bean we want to set.
     */
    p.setMittens(cat());
    /**
     * "Doesn’t this mean that we create two instances of Cat, one instance Spring creates and adds
     * into its context and another one when the person() method makes the direct call to the cat()
     * method?"
     *
     * <p>No, we actually have only one cat instance in this application overall. Spring is smart
     * enough to understand that by calling the cat() method, you want to refer to the cat bean in
     * its context. When we use the @Bean annotation to define beans into the Spring context, Spring
     * controls how the methods are called and can apply logic above the method call
     */
    return p;
  }
}
