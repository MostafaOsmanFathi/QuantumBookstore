package com.FawryRiseJourney.model.Book;

import com.FawryRiseJourney.model.Customer.Customer;
import com.FawryRiseJourney.model.Mail.MailInterface;

import java.time.LocalDate;

public class EBook extends Book {
    MailInterface mail;

    public EBook(String ISBN, String bookName, String author, double price, LocalDate outDate) {
        super(ISBN, bookName, author, price, outDate);
    }

    public EBook(String ISBN, String bookName, String author, double price, LocalDate outDate, MailInterface mail) {
        super(ISBN, bookName, author, price, outDate);
        this.mail = mail;
    }

    @Override
    public boolean isAvailable(int quantity) {
        return true;
    }

    @Override
    public double buy(int quantity, Customer customer) {
        return getPrice() * quantity;
    }

    @Override
    public boolean ApplyBuy(int quantity) {
        return true;
    }

    @Override
    public boolean decreaseQuantity(int quantity) {
        return true;
    }

    @Override
    public String getBookType() {
        return "Electronic Book";
    }

    public MailInterface getMail() {
        return mail;
    }

    public void setMail(MailInterface mail) {
        this.mail = mail;
    }
}
