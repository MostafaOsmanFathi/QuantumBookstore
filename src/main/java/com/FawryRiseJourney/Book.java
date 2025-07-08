package com.FawryRiseJourney;

import java.time.LocalDate;

public abstract class Book {
    public String ISBN;
    public String BookName;
    public String Author;
    public LocalDate OutDate;

    public Book(String ISBN, String bookName, String author, LocalDate outDate) {
        this.ISBN = ISBN;
        BookName = bookName;
        Author = author;
        OutDate = outDate;
    }

    public abstract boolean isAvailable(int quantity);

    public boolean isOutdated(LocalDate date) {
        return date.isAfter(OutDate);
    }


    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public LocalDate getOutDate() {
        return OutDate;
    }

    public void setOutDate(LocalDate outDate) {
        OutDate = outDate;
    }
}
