package com.leonelfonseca.java.di.wired.beanmultiplechoice.parameterinj.config;

import com.leonelfonseca.java.di.wired.beanmultiplechoice.qualifier.model.Cat;
import com.leonelfonseca.java.di.wired.beanmultiplechoice.qualifier.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParameterInjectionMultipleBeansWiringConfig {

  // Mr. Mittens is instantiated, although it won't have an owner :(
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
   * When using parameter injection for multiple beans, the parameter name must match the
   * corresponding bean name, such as 'tiger'. If you attempt to rename the parameter to 'Felix' and
   * it does not correspond to any defined bean method, IntelliJ will produce an inspection error:
   * 'Could not autowire. There is more than one bean of type 'Cat'.
   */
  @Bean
  Person person(Cat tiger) {

    Person p = new Person();
    p.setName("John Doe");
    p.setAge(22);
    p.setCat(tiger);

    return p;
  }
}
