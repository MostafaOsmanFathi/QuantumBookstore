package com.FawryRiseJourney.Book;

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
    public double buy(int quantity, String email) {
        throw new UnsupportedOperationException("Can't buy Demo Book");
    }

}
