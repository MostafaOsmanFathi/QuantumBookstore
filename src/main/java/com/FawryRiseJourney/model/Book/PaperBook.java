package com.FawryRiseJourney.model.Book;

import com.FawryRiseJourney.model.Customer.Customer;
import com.FawryRiseJourney.model.Shipping.ShippingInterface;

import java.time.LocalDate;

public class PaperBook extends Book {
    int stockQuantity;
    ShippingInterface shippingInterface;

    public PaperBook(String ISBN, String bookName, String author, LocalDate outDate, double price, int stockQuantity) {
        super(ISBN, bookName, author, price, outDate);
        this.stockQuantity = stockQuantity;
    }

    public PaperBook(String ISBN, String bookName, String author, LocalDate outDate, double price, int stockQuantity, ShippingInterface shippingInterface) {
        super(ISBN, bookName, author, price, outDate);
        this.stockQuantity = stockQuantity;
        this.shippingInterface = shippingInterface;
    }

    @Override
    public boolean isAvailable(int quantity) {
        return quantity <= stockQuantity;
    }

    @Override
    public boolean buy(int quantity, Customer customer) {
        if (isAvailable(quantity)) {
            stockQuantity -= quantity;
            return true;
        }
        throw new IllegalArgumentException("Not enough in the stock");
    }

    @Override
    public double getTotalPrice(int quantity) {
        return getPrice() * quantity;
    }


    @Override
    public boolean decreaseQuantity(int quantity) {
        if (isAvailable(quantity)) {
            stockQuantity -= quantity;
            return true;
        }
        throw new IllegalArgumentException("Can't decrease that quantity amount");
    }

    @Override
    public String getBookType() {
        return "Paper Book";
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public ShippingInterface getShippingInterface() {
        return shippingInterface;
    }

    public void setShippingInterface(ShippingInterface shippingInterface) {
        this.shippingInterface = shippingInterface;
    }
}
