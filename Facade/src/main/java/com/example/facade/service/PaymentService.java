package com.example.facade.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public void pay(int amount) {
        System.out.println("결제 처리: " + amount + "원");
    }
}
