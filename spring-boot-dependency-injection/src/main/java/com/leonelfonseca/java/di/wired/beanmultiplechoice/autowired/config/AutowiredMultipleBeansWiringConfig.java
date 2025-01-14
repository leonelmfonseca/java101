package com.leonelfonseca.java.di.wired.beanmultiplechoice.autowired.config;

import com.leonelfonseca.java.di.wired.beanmultiplechoice.autowired.model.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ComponentScan tells Spring where to find the classes annotated with stereotype(in this case "@Component") annotations.
 */
@ComponentScan(basePackages = "com.leonelfonseca.java.di.wired.beanmultiplechoice.autowired.model")
@Configuration
public class AutowiredMultipleBeansWiringConfig {

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

  @Bean
  public Cat felix() {
    Cat c = new Cat();
    c.setAge(2);
    c.setName("Felix");
    c.setColor("white");
    c.setBreed("Sphynx");
    c.setWeight(3d);

    System.out.println(c.getName() + ": miau!");
    return c;
  }

}
