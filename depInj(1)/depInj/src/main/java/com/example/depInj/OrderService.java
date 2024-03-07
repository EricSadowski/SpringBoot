package com.example.depInj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrderService {
    private final PaymentMethod paymentMethod;
    @Autowired
    public OrderService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public void placeOrder(double amount) {
        paymentMethod.pay(amount);
        System.out.println("Order placed successfully!");
    }
}