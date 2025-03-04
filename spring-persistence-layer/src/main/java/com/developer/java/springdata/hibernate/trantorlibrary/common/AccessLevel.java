package com.developer.java.springdata.hibernate.trantorlibrary.common;

import lombok.Getter;

@Getter
public enum AccessLevel {

    STANDARD("Standard"),
    GALACTIC("Galactic"),
    ELITE("Elite");
    
    // WARNING: The field declaration must be after the ENUM set
    private final String accessLevel;
    
    AccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }
}
