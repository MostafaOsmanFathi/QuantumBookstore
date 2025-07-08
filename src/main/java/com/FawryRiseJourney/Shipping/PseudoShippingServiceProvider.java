package com.FawryRiseJourney.Shipping;

public class PseudoShippingServiceProvider implements ShippingInterface {
    @Override
    public boolean makeShipping(String Name, String Email, String Address, String Phone, String Content) {
        System.out.println("Shipping for " + Name + " " + Email + " " + Address + " " + Phone);
        System.out.println("Product To Be Shipped " + Content);
        return true;
    }
}
