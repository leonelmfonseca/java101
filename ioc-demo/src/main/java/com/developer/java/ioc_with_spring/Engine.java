package com.developer.java.ioc_with_spring;

import org.springframework.stereotype.Component;

@Component
public class Engine {

    void start(){
        System.out.println("Engine started");
    }

}
