package com.FawryRiseJourney.Service;

import com.FawryRiseJourney.model.Book.Book;
import com.FawryRiseJourney.model.Book.DemoBook;
import com.FawryRiseJourney.model.Book.EBook;
import com.FawryRiseJourney.model.Book.PaperBook;
import com.FawryRiseJourney.model.Customer.Customer;
import com.FawryRiseJourney.model.Customer.payment.PseudoPaymentService;
import com.FawryRiseJourney.model.Mail.PseudoMailServiceProvider;
import com.FawryRiseJourney.model.Shipping.PseudoShippingServiceProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookSellingServiceTest {
    CustomerService customerService;
    InventoryService inventoryService;
    BookSellingService bookSellingService;

    PaperBook paperBook;
    EBook eBook;
    DemoBook demoBook;

    PseudoPaymentService pseudoPaymentService;
    Customer customer;

    @BeforeEach
    void setUp() {
        //inventory part
        inventoryService = InventoryService.getInventoryService();
        inventoryService.clearAllBooks();
        paperBook = null;
        eBook = null;
        demoBook = null;

        addBooks();

        //customer part
        customerService = CustomerService.getCustomerService();
        customerService.clearData();
        pseudoPaymentService = PseudoPaymentService.getPseudoPaymentService();
        pseudoPaymentService.clear();

        customer = new Customer("mostafa", "Cairo", "+2010933826460", "mostafa.osman.fathi@gmail.com");
        customerService.addCustomerDefaultPayment(customer);

        //bookSellingService part
        bookSellingService = BookSellingService.getBookSellingService();


        //deposit 1000.0$ to mostafa Account
        pseudoPaymentService.depositCustomerBalance(customer.getEmail(), 1000.0);

    }

    @Test
    void getBookSellingService() {
        assertNotNull(bookSellingService);
    }

    @Test
    void buyBook() {
        Book book = inventoryService.getBook("En-101");
        assertNotNull(book);
        assertNotNull(customer);

        assertTrue(bookSellingService.buyBook(book, 1, customer));
        assertEquals(4, ((PaperBook) book).getStockQuantity());

        assertEquals(1000.0 - 60.0, pseudoPaymentService.getCustomerBalance(customer.getEmail()));
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