package com.example.ioc_with_springboot;

import org.springframework.stereotype.Component;

@Component
public class Engine {

    void start(){
        System.out.println("Engine started");
    }

}
