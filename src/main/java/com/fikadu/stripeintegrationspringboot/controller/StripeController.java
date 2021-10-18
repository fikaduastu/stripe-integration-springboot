package com.fikadu.stripeintegrationspringboot.controller;


import com.fikadu.stripeintegrationspringboot.model.PaymentInfo;
import com.fikadu.stripeintegrationspringboot.service.StripeService;
import com.stripe.Stripe;
import com.stripe.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pay")
public class StripeController {


    //Stripe.apiKey = "sk_test_51Jl2SzB2Xgbzrw2mVEUcoG7Zof5iu8EaAMi5RQcLtUfdxyfTGN0MsUrIC4dyRmFGdqmAMv7wCamZXEyaFNdMt0HL00nCRqztK0";

    @Autowired
    private StripeService stripeService;

    @Autowired
    private PaymentRepo paymentRepo;

    private Double price = 20.0;

    @Value("${stripe.key}")
    private String stripePublicKey;

    @RequestMapping("/checkout")
    public ResponseEntity<Object> checkout(@RequestBody PaymentInfo paymentInfo){

        ResponseEntity<Object> response = stripeService.checkout(paymentInfo,stripePublicKey,price);
        return response;
    }

    public ResponseEntity<Object> checkoutByCard(PaymentInfo paymentinfo){
        //create customer if not exist

        Customer customer = stripeService.createCustomer(paymentinfo);

        //process payment to our account

        String paymentStatus = stripeService.processPayment(customer,price);

        //persist payment by payment id, restaurant account id, dasher account id, dasher cost, restaurant cost


    }
}
