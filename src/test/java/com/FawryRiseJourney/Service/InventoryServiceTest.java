package com.FawryRiseJourney.Service;

import com.FawryRiseJourney.model.Book.DemoBook;
import com.FawryRiseJourney.model.Book.EBook;
import com.FawryRiseJourney.model.Book.PaperBook;
import com.FawryRiseJourney.model.Mail.PseudoMailServiceProvider;
import com.FawryRiseJourney.model.Shipping.PseudoShippingServiceProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class InventoryServiceTest {
    InventoryService inventoryService;
    PaperBook paperBook;
    EBook eBook;
    DemoBook demoBook;

    @BeforeEach
    void setUp() {
        inventoryService = InventoryService.getInventoryService();
        inventoryService.clearAllBooks();
        paperBook = null;
        eBook = null;
        demoBook = null;
        addBooks();
    }

    @Test
    void getInventoryService() {
        assertEquals(inventoryService, InventoryService.getInventoryService());
    }

    @Test
    void reduceQuantityBy() {

    }


    @Test
    void removeBook() {
    }

    @Test
    void getBook() {
        assertEquals(paperBook, inventoryService.getBook("En-101"));
        assertEquals(eBook, inventoryService.getBook("AR-101"));
        assertEquals(demoBook, inventoryService.getBook("DU-404"));

        assertNotEquals(demoBook, inventoryService.getBook("En-101"));
    }

    @Test
    void displayAllBooks() {
        //needs to be seen in the consol
        inventoryService.displayAllBooks();
        //expected output is the 3 added books of the 3 types
    }

    void addBooks() {
        paperBook = new PaperBook(
                "En-101",
                "English B1",
                "jim karlos",
                LocalDate.of(2026, 1, 1),
                60.0,
                5,
                new PseudoShippingServiceProvider()
        );
        eBook = new EBook(
                "AR-101",
                "Arabic Mid Level",
                "Mohamed Salah",
                30.0,
                LocalDate.of(2024, 3, 5),
                PseudoMailServiceProvider.getPseudoMailServiceProvider()
        );

        demoBook = new DemoBook(
                "DU-404",
                "Dutuch Mit Gramatik",
                "Hitler",
                120,
                LocalDate.of(2030, 2, 1)
        );
        inventoryService.addBook(paperBook);
        inventoryService.addBook(eBook);
        inventoryService.addBook(demoBook);

    }
}