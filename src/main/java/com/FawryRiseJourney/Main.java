package com.FawryRiseJourney;

import com.FawryRiseJourney.Service.BookSellingService;
import com.FawryRiseJourney.Service.CustomerService;
import com.FawryRiseJourney.Service.InventoryService;
import com.FawryRiseJourney.model.Book.Book;
import com.FawryRiseJourney.model.Book.DemoBook;
import com.FawryRiseJourney.model.Book.EBook;
import com.FawryRiseJourney.model.Book.PaperBook;
import com.FawryRiseJourney.model.Customer.Customer;
import com.FawryRiseJourney.model.Customer.payment.PseudoPaymentService;
import com.FawryRiseJourney.model.Mail.PseudoMailServiceProvider;
import com.FawryRiseJourney.model.Shipping.PseudoShippingServiceProvider;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BookSellingService bookSellingService = BookSellingService.getBookSellingService();
    private static final CustomerService customerService = CustomerService.getCustomerService();
    private static final InventoryService inventoryService = InventoryService.getInventoryService();
    private static final PseudoPaymentService pseudoPaymentService = PseudoPaymentService.getPseudoPaymentService();

    public static void main(String[] args) {
        initializeProducts();

        while (true) {
            showMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleRegisteredCustomer();
                    break;
                case 2:
                    handleNewCustomerRegistration();
                    break;
                case 3:
                    handleInventoryManager();
                    break;
                case 0:
                    System.out.println("thank you for using our service");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("\n========== Welcome to Fawry Rise Bookstore ==========");
        System.out.println("1. Login as Registered Customer");
        System.out.println("2. Register a New Customer");
        System.out.println("3. Login as Inventory Manager");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    private static void handleRegisteredCustomer() {
        System.out.print("Enter your email to log in: ");
        String email = scanner.nextLine();

        Customer customer = customerService.getCustomer(email);
        if (customer == null) {
            System.out.println("Customer not found. Please register first.");
            return;
        }

        boolean running = true;
        while (running) {
            showRegisteredCustomerMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showBooksInInventory();
                    break;
                case 2:
                    buyBook(customer);
                    break;
                case 3:
                    showCustomerOrders(customer);
                    break;
                case 4:
                    depositMoney(customer);
                    break;
                case 5:
                    withdrawMoney(customer);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    private static void showRegisteredCustomerMenu() {
        System.out.println("\nCustomer Menu");
        System.out.println("1. Show Books in Inventory");
        System.out.println("2. Buy a Book");
        System.out.println("3. Show My Orders");
        System.out.println("4. Deposit Money");
        System.out.println("5. Withdraw Money");
        System.out.println("0. Logout");
        System.out.print("Choose: ");
    }

    private static void handleNewCustomerRegistration() {
        System.out.println("\nadd New Customer");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Customer customer = new Customer(name, address, phone, email);
        customerService.addCustomerDefaultPayment(customer);
        System.out.println("Customer registered successfully");
    }

    private static void handleInventoryManager() {
        boolean running = true;
        while (running) {
            showInventoryMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showBooksInInventory();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    removeOutdatedBooks();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    private static void showInventoryMenu() {
        System.out.println("\n--- Inventory Manager Menu ---");
        System.out.println("1. Show Books in Inventory");
        System.out.println("2. Add Book");
        System.out.println("3. Remove Book");
        System.out.println("4. Remove Outdated Books");
        System.out.println("0. Logout");
        System.out.print("Choose: ");
    }

    private static void showBooksInInventory() {
        inventoryService.displayAllBooks();
    }

    private static void buyBook(Customer customer) {

    }

    private static void showCustomerOrders(Customer customer) {
        customerService.getCustomerOrders(customer);
    }

    private static void depositMoney(Customer customer) {
        System.out.println("\nDeposit Money");
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (pseudoPaymentService.depositCustomerBalance(customer.getEmail(), amount)) {
            System.out.println("deposit successfully");
        } else {
            System.out.println("deposit failed");
        }
    }

    private static void withdrawMoney(Customer customer) {
        System.out.println("\nwithdraw Money");
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (pseudoPaymentService.withdrawCustomerBalance(customer.getEmail(), amount)) {
            System.out.println("withdraw successfully");
        } else {
            System.out.println("withdraw failed");
        }
    }

    private static void addBook() {
        System.out.println("\n--- Add New Book ---");
        System.out.println("Select Book Type:");
        System.out.println("1. Paper Book");
        System.out.println("2. E-Book");
        System.out.println("3. Demo Book");

        System.out.print("Choose: ");
        int type = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Enter Book Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Outdate (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        LocalDate outDate = LocalDate.parse(dateStr);
        Book book = null;
        switch (type) {
            case 1:
                System.out.print("Enter stock quantity: ");
                int stock = scanner.nextInt();
                scanner.nextLine();

                book = new PaperBook(isbn, name, author, outDate, price, stock);

                break;
            case 2:
                book = new EBook(isbn, name, author, price, outDate, PseudoMailServiceProvider.getPseudoMailServiceProvider());
                break;
            case 3:
                book = new DemoBook(isbn, name, author, price, outDate);
                break;
            default:
                System.out.println("Invalid type");
        }

        if (book != null) {
            inventoryService.addBook(book);
            System.out.println("Book added successfully");
        } else {
            System.out.println("Book did not added");
        }
    }

    private static void removeBook() {
        System.out.println("\nRemove Book");
        System.out.print("Enter Book ISBN: ");
        String bookISBN = scanner.nextLine();
        inventoryService.removeBook(bookISBN);
    }

    private static void removeOutdatedBooks() {
        System.out.println("\nRemove Outdated Books");
        inventoryService.removeOutdatedBooks();
    }

    private static void initializeProducts() {
        inventoryService.addBook(new PaperBook(
                "En-101",
                "English B1",
                "Jim Karlos",
                LocalDate.of(2026, 1, 1),
                0,
                5,
                PseudoShippingServiceProvider.getPseudoShippingServiceProvider()
        ));

        inventoryService.addBook(new EBook(
                "AR-101",
                "Arabic Mid Level",
                "Mohamed Salah",
                30.0,
                LocalDate.of(2024, 3, 5),
                PseudoMailServiceProvider.getPseudoMailServiceProvider()
        ));

        inventoryService.addBook(new DemoBook(
                "DU-404",
                "Dutuch Mit Gramatik",
                "Hitler",
                120,
                LocalDate.of(2030, 2, 1)
        ));
    }
}
