package com.fikadu.stripeintegrationspringboot.service;


import com.fikadu.stripeintegrationspringboot.model.PaymentInfo;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {


    private String email = "1988.fikadufilipos@gmail.com";
    public ResponseEntity<Object> checkout(PaymentInfo paymentInfo,String stripePublicKey, Double price){


        ResponseEntity<Object> response;
        Customer customer = createCustomer(email, stripePublicKey);
        if (customer != null){
            response = processPayment(paymentInfo,customer,price);
        }

        return null;
    }

    private ResponseEntity<Object> processPayment(PaymentInfo paymentInfo, Customer customer, Double price) {
        String cardNumber = paymentInfo.getCardNumber();
        String cvc = paymentInfo.getCvc();
        int expirationMonth = paymentInfo.getExpirationMonth();
        int expirationYear = paymentInfo.getExpirationYear();
        String email = paymentInfo.getUserEmail();
        return null;
    }


    //Intent for payment
    public Customer createCustomer(String email, String stripePublicKey){
        Stripe.apiKey = stripePublicKey;
        Customer customer = null;
        Map<String, Object> customerMap = new HashMap<String, Object>();
        customerMap.put("email", email);
        customerMap.put("description", "payment for food order");
        customerMap.put("payment_method", "card");

        try {
            customer = Customer.create(customerMap);
        } catch (StripeException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
