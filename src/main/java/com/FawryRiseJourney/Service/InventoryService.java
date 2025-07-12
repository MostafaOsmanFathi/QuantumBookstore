package com.FawryRiseJourney.Service;

import com.FawryRiseJourney.model.Book.Book;

import java.util.HashMap;

public class InventoryService {
    private static InventoryService inventoryService;

    private InventoryService() {

    }

    public static InventoryService getInstance() {
        if (inventoryService == null) {
            inventoryService = new InventoryService();
        }
        return inventoryService;
    }

    //                     ISBN    bookObject
    private final HashMap<String, Book> booksInventory = new HashMap<>();

    public boolean reduceQuantityBy(String ISBN, int quantity) {
        if (!booksInventory.containsKey(ISBN)) {
            throw new IllegalCallerException("Book does not exist");
        }
        Book book = booksInventory.get(ISBN);
        return book.decreaseQuantity(quantity);
    }

    public boolean addBook(Book book) {
        if (!booksInventory.containsKey(book.getISBN())) {
            return false;
        }
        booksInventory.put(book.getISBN(), book);
        System.out.println("Book with ISBN " + book.getISBN() + " added Successfully");
        return true;
    }

    public boolean removeBook(Book book) {
        if (!booksInventory.containsKey(book.getISBN())) {
            return true;
        }
        return booksInventory.remove(book.getISBN(), book);
    }

    public Book getBook(String ISBN) {
        if (!booksInventory.containsKey(ISBN)) {
            return null;
        }
        return booksInventory.get(ISBN);
    }

    public void displayAllBooks() {
        for (Book book : booksInventory.values()) {
            System.out.println(book);
        }
    }
}
