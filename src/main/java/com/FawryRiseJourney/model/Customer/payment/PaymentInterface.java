package com.FawryRiseJourney.model.Customer.payment;

import com.FawryRiseJourney.model.Customer.Customer;

public interface PaymentInterface {
    public boolean charge(Customer customer, double amount);

    public boolean refund(Customer customer, double amount);
}
