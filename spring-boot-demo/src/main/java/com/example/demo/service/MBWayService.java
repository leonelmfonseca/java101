package com.example.demo.service;

public class MBWayService implements PaymentService{

    @Override
    public void pay() {
        System.out.println("MBWay payment");
    }
}
