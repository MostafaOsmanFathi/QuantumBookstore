package com.FawryRiseJourney.model.Customer;

import com.FawryRiseJourney.model.Customer.order.Order;
import com.FawryRiseJourney.model.Customer.payment.PaymentInterface;
import com.FawryRiseJourney.model.Customer.payment.PseudoPaymentService;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String address;
    private String phone;
    private String email;

    private final List<Order> orders;

    PaymentInterface payment;

    public Customer(String name, String address, String phone, String email, PaymentInterface payment) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.payment = payment;
        this.orders = new ArrayList<>();
    }

    public Customer(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.payment = PseudoPaymentService.getPseudoPaymentService();
        this.orders = new ArrayList<>();
    }

    public boolean addOrder(Order order) {
        return orders.add(order);
    }

    public String getAllOrders() {
        if (orders.isEmpty()) {
            return "Customer has no orders";
        }
        StringBuilder ordersMessage = new StringBuilder();
        for (Order order : orders) {
            ordersMessage.append(order.toString());
        }
        return ordersMessage.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PaymentInterface getPayment() {
        return payment;
    }

    public void setPayment(PaymentInterface payment) {
        this.payment = payment;
    }

}
