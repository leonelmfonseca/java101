package com.leonelfonseca.java.di.wired.directmethodwiring.model;

import lombok.Data;

@Data
public class Person {

  private String name;
  private int age;

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
