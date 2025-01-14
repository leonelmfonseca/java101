package com.leonelfonseca.java.di.wired.beanmultiplechoice.autowired.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Person {

  private String name="Anthony Doe";
  private int age = 86;

  /**
   * Attention! Don't forget, Persons Car parameter name must match a bean name(method) of config file!
   */
  private Cat happyCat;

  public Person(Cat felix) {
    this.happyCat = felix;
  }

  @Override
  public String toString() {
    return "Person{" + "name='" + name + '\'' + ", age=" + age + ", cat=" + happyCat + '}';
  }
}
