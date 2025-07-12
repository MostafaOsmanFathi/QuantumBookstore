package com.FawryRiseJourney.Service;

import com.FawryRiseJourney.model.Customer.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CustomerServiceTest {

    CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = CustomerService.getCustomerService();
        customerService.clearData();
    }

    @Test
    void getCustomerService() {
        assertNotNull(CustomerService.getCustomerService());
    }

    @Test
    void testAddCustomerAndGetCustomer() {
        Customer customer = new Customer("mostafa", "Cairo", "+2010933826460", "mostafa.osman.fathi@gmail.com");
        customerService.addCustomerDefaultPayment(customer);
        assertEquals(customer, customerService.getCustomer("mostafa.osman.fathi@gmail.com"));
    }
}