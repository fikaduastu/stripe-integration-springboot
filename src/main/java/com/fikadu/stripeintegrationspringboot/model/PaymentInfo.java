package com.fikadu.stripeintegrationspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentInfo {

    private String cardNumber;
    private int expirationMonth;
    private int expirationYear;
    private String cvc;
    private String userEmail;
}
