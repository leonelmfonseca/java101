package com.developer.java.fundamentals.parameterpassing;

enum CarBrand {
    VOLVO("Volvo"),
    MERCEDES("Mercedes"),
    FORD("Ford"),
    FERRARI("Ferrari"),
    RENAULT("Renault");

    private final String brandName;

    CarBrand(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }
}
