package com.developer.java.fundamentals.copy;

public interface MemoryAddress {
    default String getMemoryAddress() {
        return Integer.toHexString(System.identityHashCode(this));
    }
}
