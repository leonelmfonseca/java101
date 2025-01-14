package com.leonelfonseca.java.di.wired.autowiredoption.ctorinjection.component;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
/**
 * The class is a Spring-managed component, which means Spring will automatically detect it and
 * register it in the application context. and it will handle the lifecycle of the class, including
 * its instantiation and dependency injection.Classes annotated with @Component (and its
 * specializations like @Service, @Repository, and @Controller) are automatically detected through
 * classpath scanning, typically using the @ComponentScan annotation. Spring can inject dependencies
 * into these components using annotations like @Autowired.
 */
@Component
public class Cat {
  private String name = "Mittens";
  private String breed = "Siamese";
  private int age = 5; // in years
  private double weight = 3.4; // in kilograms
  private String color = "black";

  /*
   @Autowired: as this object doesn't have any dependencies, annotating it with @Autowired(DI),
   without ctor params(dependencies) will return: "Autowired constructor without parameters"
   */
  public Cat() {
    /**
     * Having a default constructor in CtorInjectionCat ensures that Spring can instantiate the bean
     * correctly
     */
    System.out.println("Miau!");
  }

  @Override
  public String toString() {
    return "Cat{"
        + "name='"
        + name
        + '\''
        + ", breed='"
        + breed
        + '\''
        + ", age="
        + age
        + ", weight="
        + weight
        + ", color='"
        + color
        + '\''
        + '}';
  }
}
