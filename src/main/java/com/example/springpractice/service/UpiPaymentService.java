package com.example.springpractice.service;

import org.springframework.stereotype.Service;

@Service("upiService")
public class UpiPaymentService implements PaymentService{
    @Override
    public String pay() {
        return "UPI payment successful";
    }
}
