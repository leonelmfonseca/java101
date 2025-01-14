package com.example.demo.service;

public class CreditCardService implements PaymentService{
    @Override
    public void pay() {
        System.out.println("Credit Card payment");
    }
}
