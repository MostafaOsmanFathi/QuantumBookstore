package com.FawryRiseJourney.Service;

import com.FawryRiseJourney.model.Book.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class InventoryService {
    private static InventoryService inventoryService;

    private InventoryService() {

    }

    public static InventoryService getInventoryService() {
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
        if (booksInventory.containsKey(book.getISBN())) {
            System.out.println("Book with ISBN " + book.getISBN() + " all ready added");
            return false;
        }
        booksInventory.put(book.getISBN(), book);
        System.out.println("Book with ISBN " + book.getISBN() + " added Successfully");
        return true;
    }

    public boolean removeBook(Book book) {
        return removeBook(book.getISBN());
    }

    public boolean removeBook(String ISBN) {
        if (!booksInventory.containsKey(ISBN)) {
            return false;
        }
        booksInventory.remove(ISBN);
        return true;
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

    public void clearAllBooks() {
        booksInventory.clear();
    }

    public void removeOutdatedBooks() {
        ArrayList<Book> outdatedBooks = new ArrayList<>();

        for (Book book : booksInventory.values()) {
            if (book.isOutdated(LocalDate.now())) {
                outdatedBooks.add(book);
            }
        }
        if (outdatedBooks.isEmpty()) {
            System.out.println("No books outdated");
            return;
        }

        System.out.println("Outdated books " + outdatedBooks.size() + " books deleted");
        int index = 1;
        for (Book book : outdatedBooks) {

            System.out.println(index++ + ". " + book.toString());

            removeBook(book);
        }
        outdatedBooks.clear();
    }
}
