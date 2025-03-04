package com.developer.java.springdata.hibernate.trantorlibrary.common;

public enum Status {
    PENDING("Pending"),
    APPROVED("Approved"),
    FULFILLED("Fulfilled"),
    DENIED("Denied");
    
    private final String status;
    
    Status(String status) {
        this.status = status;
    }
}
