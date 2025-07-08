package com.FawryRiseJourney.model.Inventory;

import com.FawryRiseJourney.model.Book.Book;

import java.util.HashMap;

public class Inventory {
    //      ISBN    bookObject
    private final HashMap<String, Book> booksInventory = new HashMap<>();

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


}
