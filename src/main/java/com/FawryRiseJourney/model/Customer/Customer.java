package com.FawryRiseJourney.model.Customer;

public class Customer {
    String name;
    String address;
    String phone;
    String email;

    PaymentInterface payment;

    public Customer(String name, String address, String phone, String email, PaymentInterface payment) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.payment = payment;
    }

    public Customer(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.payment = PseudoPaymentService.getPseudoPaymentService();
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
