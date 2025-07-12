package com.FawryRiseJourney.Service;

import com.FawryRiseJourney.model.Customer.Customer;
import com.FawryRiseJourney.model.Customer.payment.PseudoPaymentService;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    static CustomerService customerService;
    //  Email , Customer Obj
    Map<String, Customer> customerRepository;

    private CustomerService() {
        customerRepository = new HashMap<String, Customer>();
    }

    public static CustomerService getCustomerService() {
        if (customerService == null) {
            customerService = new CustomerService();
        }
        return customerService;
    }

    public boolean addCustomerDefaultPayment(Customer customer) {
        return addCustomer(customer, PseudoPaymentService.getPseudoPaymentService());
    }

    public void getCustomerOrders(Customer customer) {
        System.out.println(customer.getAllOrders());
    }

    public boolean addCustomer(Customer customer, PseudoPaymentService pseudoPaymentService) {
        if (customerRepository == null) {
            return false;
        }
        customerRepository.put(customer.getEmail(), customer);
        customer.setPayment(pseudoPaymentService);
        return true;
    }

    public Customer getCustomer(String email) {
        return customerRepository.get(email);
    }

    public void clearData() {
        customerRepository.clear();
    }
}
