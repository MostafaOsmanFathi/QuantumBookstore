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

    @BeforeEach
    void setUp() {
        inventoryService = InventoryService.getInventoryService();
        inventoryService.clearAllBooks();
    }

    @Test
    void getInventoryService() {
    }

    @Test
    void reduceQuantityBy() {
    }

    @Test
    void addBooks() {
        PaperBook paperBook = new PaperBook(
                "En-101",
                "English B1",
                "jim karlos",
                LocalDate.of(2026, 1, 1),
                60.0,
                5,
                new PseudoShippingServiceProvider()
        );
        EBook eBook = new EBook(
                "AR-101",
                "Arabic Mid Level",
                "Mohamed Salah",
                30.0,
                LocalDate.of(2024, 3, 5),
                PseudoMailServiceProvider.getPseudoMailServiceProvider()
        );

        DemoBook demoBook = new DemoBook(
                "DU-404",
                "Dutuch Mit Gramatik",
                "Hitler",
                120,
                LocalDate.of(2030, 2, 1)
        );
        inventoryService.addBook(paperBook);
        inventoryService.addBook(eBook);
        inventoryService.addBook(demoBook);

        assertEquals(paperBook, inventoryService.getBook("En-101"));
        assertEquals(eBook, inventoryService.getBook("AR-101"));
        assertEquals(demoBook, inventoryService.getBook("DU-404"));

        assertNotEquals(demoBook, inventoryService.getBook("En-101"));

    }

    @Test
    void removeBook() {
    }

    @Test
    void getBook() {
    }

    @Test
    void displayAllBooks() {
    }
}