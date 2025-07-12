package com.FawryRiseJourney.model.Customer.payment;

import com.FawryRiseJourney.model.Customer.Customer;

import java.util.HashMap;

//Singleton
public class PseudoPaymentService implements PaymentInterface {
    //                     Email, balance
    private static HashMap<String, Double> customerBalanceRepository;
    static PseudoPaymentService pseudoPaymentService;

    private PseudoPaymentService() {
        customerBalanceRepository = new HashMap<String, Double>();
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
        if (!customerBalanceRepository.containsKey(customer.getEmail())) {
            customerBalanceRepository.put(customer.getEmail(), 0.0);
        }
        double balance = customerBalanceRepository.get(customer.getEmail());
        if (balance < amount) {
            return false;
        }
        customerBalanceRepository.put(customer.getEmail(), balance - amount);
        return true;
    }

    @Override
    public boolean refund(Customer customer, double amount) {
        if (customer == null) {
            return false;
        }
        if (!customerBalanceRepository.containsKey(customer.getEmail())) {
            customerBalanceRepository.put(customer.getEmail(), 0.0);
        }
        double balance = customerBalanceRepository.get(customer.getEmail());
        customerBalanceRepository.put(customer.getEmail(), balance + amount);
        return false;
    }
}
