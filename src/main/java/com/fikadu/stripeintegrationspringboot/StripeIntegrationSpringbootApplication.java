package com.fikadu.stripeintegrationspringboot;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class StripeIntegrationSpringbootApplication {

    public static void main(String[] args) throws StripeException {
        SpringApplication.run(StripeIntegrationSpringbootApplication.class, args);
        createCustomer();
    }

    public static void createCustomer() throws StripeException {
        Stripe.apiKey = "sk_test_51Jl2SzB2Xgbzrw2mVEUcoG7Zof5iu8EaAMi5RQcLtUfdxyfTGN0MsUrIC4dyRmFGdqmAMv7wCamZXEyaFNdMt0HL00nCRqztK0";


//        Map<String,Object> customerData = new HashMap<>();
//        customerData.put("email","1988.fikadufilipos@gmail.com");
//        Customer customer = Customer.create(customerData);

//        Customer customer1 = Customer.retrieve("cus_KQFgok31Z8v1Qy")
//        customer1.setBalance(20000L);
//
//        Long balance = customer1.getBalance() - 2000;
//        customer1.setBalance(balance);
        //System.out.println(customer1);


        Map<String, Object> options = new HashMap<>();
        options.put("email", "jane@example.com");
        List<Customer> customers = Customer.list(options).getData();
        Customer customer = null;
        if (customers.size() > 0) {
            customer = customers.get(0);
        }

        System.out.println(customer);

    }
}
