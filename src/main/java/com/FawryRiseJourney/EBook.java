package com.FawryRiseJourney;

import java.time.LocalDate;

public class EBook extends Book {
    public EBook(String ISBN, String bookName, String author, LocalDate outDate) {
        super(ISBN, bookName, author, outDate);
    }

    @Override
    public boolean isAvailable(int quantity) {
        return true;
    }

}
