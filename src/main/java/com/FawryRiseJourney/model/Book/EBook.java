package com.FawryRiseJourney.model.Book;

import com.FawryRiseJourney.model.Customer.Customer;

import java.time.LocalDate;

public class EBook extends Book {
    public EBook(String ISBN, String bookName, String author, double price, LocalDate outDate) {
        super(ISBN, bookName, author, price, outDate);
    }

    @Override
    public boolean isAvailable(int quantity) {
        return true;
    }

    @Override
    public double buy(int quantity, Customer customer) {
        return getPrice() * quantity;
    }

}
