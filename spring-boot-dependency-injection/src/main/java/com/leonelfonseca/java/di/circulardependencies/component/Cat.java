package com.leonelfonseca.java.di.circulardependencies.component;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class Cat {
  private String name = "Mittens";
  private String breed = "Siamese";
  private int age = 5; // in years
  private double weight = 3.4; // in kilograms
  private String color = "black";

  private final Person circularDependenciesPerson;


  /**
   * Cat requests a dependency to Bean Person, so, to create Bean Cat, Spring needs first to have Bean Person.
   */
  @Autowired
  public Cat(Person circularDependenciesPerson) {
      this.circularDependenciesPerson = circularDependenciesPerson;


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
