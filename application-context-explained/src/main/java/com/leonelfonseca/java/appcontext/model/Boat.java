package com.leonelfonseca.java.appcontext.model;

public class Boat {
  private String name;
  private double length;
  private String type;
  private int yearBuilt;

  // Default constructor
  public Boat() {}

  // Parameterized constructor
  public Boat(String name, double length, String type, int yearBuilt) {
    this.name = name;
    this.length = length;
    this.type = type;
    this.yearBuilt = yearBuilt;
  }

  // Getters and setters
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getYearBuilt() {
    return yearBuilt;
  }

  public void setYearBuilt(int yearBuilt) {
    this.yearBuilt = yearBuilt;
  }

  // toString method
  @Override
  public String toString() {
    return "Boat{"
        + "name='"
        + name
        + '\''
        + ", length="
        + length
        + ", type='"
        + type
        + '\''
        + ", yearBuilt="
        + yearBuilt
        + '}';
  }
}
