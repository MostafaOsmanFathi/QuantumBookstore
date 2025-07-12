package com.FawryRiseJourney.Service;

import com.FawryRiseJourney.model.Book.Book;
import com.FawryRiseJourney.model.Book.EBook;
import com.FawryRiseJourney.model.Book.PaperBook;
import com.FawryRiseJourney.model.Customer.Customer;
import com.FawryRiseJourney.model.Customer.order.Order;
import com.FawryRiseJourney.model.Customer.order.OrderStatus;

public class BookSellingService {
    static private BookSellingService bookSellingService;

    public static BookSellingService getBookSellingService() {
        if (bookSellingService == null) {
            bookSellingService = new BookSellingService();
        }
        return bookSellingService;
    }

    private BookSellingService() {
    }

    public boolean buyBook(Book book, int quantity, Customer customer) {
        double price = book.getTotalPrice(quantity);

        if (customer.getPayment().charge(customer, price)) {
            if (book.buy(quantity,customer)) {
                System.out.println("customer wiht name :" + customer.getName() + "Bought");
                if (book instanceof EBook eBook) {
                    System.out.println("Ebook with This Data:");
                    System.out.println("customer wiht name :" + customer.getName() + "Bought");
                    eBook.getMail().sendMailBuyEmail(customer.getEmail(), book.toString() + " Quanitiy: " + quantity);
                    customer.addOrder(new Order(book, quantity, OrderStatus.MAIL_SENT));

                } else if (book instanceof PaperBook paperBook) {
                    System.out.println("PaperBook with This Data:");
                    System.out.println("customer wiht name :" + customer.getName() + "Bought");
                    paperBook.getShippingInterface().makeShipping(customer, paperBook.toString() + " Quanitiy: " + quantity);
                    customer.addOrder(new Order(book, quantity, OrderStatus.SHIPPED));
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
