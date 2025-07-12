package com.FawryRiseJourney.model.Book;

import com.FawryRiseJourney.model.Customer.Customer;

import java.time.LocalDate;

public class DemoBook extends Book {
    public DemoBook(String ISBN, String bookName, String author, double price, LocalDate outDate) {
        super(ISBN, bookName, author, price, outDate);
    }

    @Override
    public boolean isAvailable(int quantity) {
        return false;
    }

    @Override
    public boolean buy(int quantity, Customer customer) {
        throw new UnsupportedOperationException("Can't buy Demo Book");
    }

    @Override
    public double getTotalPrice(int quantity) {
        return 0;
    }

    @Override
    public boolean decreaseQuantity(int quantity) {
        throw new UnsupportedOperationException("Demo Book does not decrease quantity");
    }

    @Override
    public String getBookType() {
        return "Demo Book";
    }

}
