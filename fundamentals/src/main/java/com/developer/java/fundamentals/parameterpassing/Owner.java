package com.developer.java.fundamentals.parameterpassing;

enum Owner {
    JOHN("John Travolta"),
    UMA("Uma Thurman"),
    ANGELINA("Angelina Jolie"),
    JOSH("Josh Brolin"),
    CLINT("Clint Eastwood");

    private final String name;

    Owner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
