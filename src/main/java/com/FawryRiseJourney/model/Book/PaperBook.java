package com.FawryRiseJourney.model.Book;

import com.FawryRiseJourney.model.Customer.Customer;

import java.time.LocalDate;

public class PaperBook extends Book {
    int stockQuantity;

    public PaperBook(String ISBN, String bookName, String author, LocalDate outDate, double price, int stockQuantity) {
        super(ISBN, bookName, author, price, outDate);
        this.stockQuantity = stockQuantity;
    }

    @Override
    public boolean isAvailable(int quantity) {
        return quantity <= stockQuantity;
    }

    @Override
    public double buy(int quantity, Customer customer) {
        if (isAvailable(quantity)) {
            return getPrice() * quantity;
        }
        throw new IllegalArgumentException("Not enough in the stock");

    }
}
