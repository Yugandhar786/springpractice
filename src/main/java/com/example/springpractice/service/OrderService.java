package com.example.springpractice.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    private CardPaymentService cardPaymentService;
    private UpiPaymentService upiPaymentService;

    public OrderService( @Qualifier("cardService")CardPaymentService cardPaymentService,
                         @Qualifier("upiService") UpiPaymentService upiPaymentService ){
        this.cardPaymentService=cardPaymentService;
        this.upiPaymentService=upiPaymentService;

    }

    public String placeOrder(String paymentType){

        String paymentSuccess = paymentType.equals("upi") ? upiPaymentService.pay() : cardPaymentService.pay();

        return "order Placed | "+paymentSuccess;
    }

}
