package com.leonelfonseca.java.di.wired.beanmultiplechoice.parameterinj.model;

import lombok.Data;

@Data
public class Person {

  private String name = "Paul Doe";
  private int age = 12;

  /**
   * Person delegate to the other in the implementation of their responsibilities. A Person has-a
   * Cat
   */
  private Cat cat;

  @Override
  public String toString() {
    return "Person{" + "name='" + name + '\'' + ", age=" + age + ", cat=" + cat + '}';
  }
}
