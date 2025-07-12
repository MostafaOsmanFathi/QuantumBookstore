package com.FawryRiseJourney.model.Customer.order;

import com.FawryRiseJourney.model.Book.Book;

public class Order {
    private final Book book;
    private final int quantity;
    private OrderStatus status;

    public Order(Book book, int quantity, OrderStatus status) {
        this.book = book;
        this.quantity = quantity;
        this.status = status;
    }

    public Order(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
        this.status = OrderStatus.PENDING;
    }

    public double getTotalPrice() {
        return book.getPrice() * quantity;
    }

    public String getOrderDetails() {
        return "Order Status: " + status.name() + book.getBookType() + " Book Data:" + book;
    }

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }
}
