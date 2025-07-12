package com.FawryRiseJourney.Service;

import com.FawryRiseJourney.model.Book.Book;
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
            if (book.buy(quantity, customer)) {

                customer.addOrder(new Order(
                        book, quantity, book.getOrderStatusType()
                ));

            } else {
                customer.getPayment().refund(customer, price);
                customer.addOrder(new Order(
                        book, quantity, OrderStatus.REFUNDED
                ));
            }
        }
        return false;

    }
}
