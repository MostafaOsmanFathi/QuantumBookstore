package com.FawryRiseJourney.model.Shipping;

import com.FawryRiseJourney.model.Customer.Customer;

public class PseudoShippingServiceProvider implements ShippingInterface {
    @Override
    public boolean makeShipping(Customer customer, String Content) {
        System.out.println("Shipping for " + customer.getName() + " " + customer.getEmail() + " " + customer.getAddress() + " " + customer.getPhone());
        System.out.println("Product To Be Shipped " + Content);
        return true;
    }
}
