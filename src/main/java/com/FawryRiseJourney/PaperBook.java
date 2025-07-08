package com.FawryRiseJourney;

import java.time.LocalDate;

public class PaperBook extends Book {
    int stockQuantity;

    public PaperBook(String ISBN, String bookName, String author, LocalDate outDate, int stockQuantity) {
        super(ISBN, bookName, author, outDate);
        this.stockQuantity = stockQuantity;
    }

    @Override
    public boolean isAvailable(int quantity) {
        return quantity <= stockQuantity;
    }
}
