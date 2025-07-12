package com.FawryRiseJourney.model.Book;

import com.FawryRiseJourney.model.Customer.Customer;

import java.time.LocalDate;

public abstract class Book {
    private String ISBN;
    private String BookName;
    private String Author;
    private LocalDate OutDate;


    private double price;

    public Book(String ISBN, String bookName, String author, double price, LocalDate outDate) {
        this.ISBN = ISBN;
        BookName = bookName;
        Author = author;
        OutDate = outDate;
        this.price = price;
    }

    public abstract boolean isAvailable(int quantity);

    public abstract boolean buy(int quantity, Customer customer);

    public abstract double getTotalPrice(int quantity);

    public abstract boolean decreaseQuantity(int quantity);

    public abstract String getBookType();

    public boolean isOutdated(LocalDate date) {
        return date.isAfter(OutDate);
    }

    @Override
    public String toString() {
        return "{ISBN='" + ISBN + "', BookName='" + BookName + "', Author='" + Author + "', OutDate=" + OutDate + ", Price=" + price + "}";
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
