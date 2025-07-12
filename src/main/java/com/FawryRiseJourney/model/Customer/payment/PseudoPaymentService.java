package com.FawryRiseJourney.model.Customer.payment;

import com.FawryRiseJourney.model.Customer.Customer;

import java.util.HashMap;

//Singleton
public class PseudoPaymentService implements PaymentInterface {
    //                     Email, balance
    private static HashMap<String, Double> customerBalance;
    static PseudoPaymentService pseudoPaymentService;

    private PseudoPaymentService() {
    }

    static public PseudoPaymentService getPseudoPaymentService() {
        if (pseudoPaymentService == null) {
            pseudoPaymentService = new PseudoPaymentService();
        }
        return pseudoPaymentService;
    }

    @Override
    public boolean charge(Customer customer, double amount) {
        if (customer == null) {
            return false;
        }
        if (!customerBalance.containsKey(customer.getEmail())) {
            customerBalance.put(customer.getEmail(), 0.0);
        }
        double balance = customerBalance.get(customer.getEmail());
        if (balance < amount) {
            return false;
        }
        customerBalance.put(customer.getEmail(), balance - amount);
        return true;
    }

    @Override
    public boolean refund(Customer customer, double amount) {
        if (customer == null) {
            return false;
        }
        if (!customerBalance.containsKey(customer.getEmail())) {
            customerBalance.put(customer.getEmail(), 0.0);
        }
        double balance = customerBalance.get(customer.getEmail());
        customerBalance.put(customer.getEmail(), balance + amount);
        return false;
    }
}
