package com.leonelfonseca.java.di.wired.beanmultiplechoice.parameterinj.model;

import lombok.Data;

@Data
public class Cat {
  private String name;
  private String breed;
  private int age; // in years
  private double weight; // in kilograms
  private String color;

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
