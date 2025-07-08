package com.FawryRiseJourney.Service;

import com.FawryRiseJourney.model.Book.Book;
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

    boolean buyBook(Book book,int quantity , Customer customer) {
        double price = book.getPrice();
        customer.getPayment().charge()
    }

}
