package com.FawryRiseJourney.Service;

import com.FawryRiseJourney.model.Book.Book;
import com.FawryRiseJourney.model.Book.EBook;
import com.FawryRiseJourney.model.Book.PaperBook;
import com.FawryRiseJourney.model.Customer.Customer;

public class BookSellingService {
    static private BookSellingService bookSellingService;

    BookSellingService getBookSellingService() {
        if (bookSellingService == null) {
            bookSellingService = new BookSellingService();
        }
        return bookSellingService;
    }

    private BookSellingService() {
    }

    boolean buyBook(Book book, int quantity, Customer customer) {
        double price = book.buy(quantity, customer);
        if (customer.getPayment().charge(customer, price)) {
            if (book.ApplyBuy(quantity)) {
                System.out.println("customer wiht name :" + customer.getName() + "Bought");
                if (book instanceof EBook eBook) {
                    System.out.println("Ebook with This Data:");
                    System.out.println("customer wiht name :" + customer.getName() + "Bought");
                    eBook.getMail().sendMailBuyEmail(customer.getEmail(), book.toString() + " Quanitiy: " + quantity);

                } else if (book instanceof PaperBook paperBook) {
                    System.out.println("PaperBook with This Data:");
                    System.out.println("customer wiht name :" + customer.getName() + "Bought");
                    paperBook.getShippingInterface().makeShipping(customer, paperBook.toString() + " Quanitiy: " + quantity);
                } else {
                    throw new RuntimeException();
                }
            } else {
                customer.getPayment().refund(customer, price);
            }
        }
        return false;

    }
}
