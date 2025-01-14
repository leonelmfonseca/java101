package com.leonelfonseca.java.di.wired.autowiredoption.setterinjection.component;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The class is a Spring-managed component, which means Spring will automatically detect it and
 * register it in the application context. and it will handle the lifecycle of the class, including
 * its instantiation and dependency injection.Classes annotated with @Component (and its
 * specializations like @Service, @Repository, and @Controller) are automatically detected through
 * classpath scanning, typically using the @ComponentScan annotation. Spring can inject dependencies
 * into these components using annotations like @Autowired.
 */
@Component
@Data
public class Person {

  private String name = "Mary";
  private int age = 43;

  private Cat mittens;

  @Autowired
  public void setMittens(Cat mittens) {
    this.mittens = mittens;
  }

  @Override
  public String toString() {
    return "Person{" + "name='" + name + '\'' + ", age=" + age + ", cat=" + mittens + '}';
  }
}
