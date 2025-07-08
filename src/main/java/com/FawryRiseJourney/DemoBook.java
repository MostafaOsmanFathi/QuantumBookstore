package com.FawryRiseJourney;

import java.time.LocalDate;

public class DemoBook extends Book {
    public DemoBook(String ISBN, String bookName, String author, LocalDate outDate) {
        super(ISBN, bookName, author, outDate);
    }

    @Override
    public boolean isAvailable(int quantity) {
        return false;
    }

}
