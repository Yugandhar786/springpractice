package com.example.springpractice.service;

import org.springframework.stereotype.Service;

@Service("cardService")
public class CardPaymentService  implements PaymentService{

    @Override
    public String pay() {
        return "Card Payment Successful";
    }
}
