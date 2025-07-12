package com.FawryRiseJourney;

import com.FawryRiseJourney.model.Book.EBook;
import com.FawryRiseJourney.model.Book.PaperBook;
import com.FawryRiseJourney.model.Customer.Customer;
import com.FawryRiseJourney.model.Customer.payment.PseudoPaymentService;
import com.FawryRiseJourney.model.Mail.PseudoMailServiceProvider;
import com.FawryRiseJourney.model.Shipping.PseudoShippingServiceProvider;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Customer customer;
    static PseudoPaymentService paymentService = PseudoPaymentService.getPseudoPaymentService();

    static PaperBook paperBook = new PaperBook(
            "PB-001",
            "Clean Code",
            "Robert C. Martin",
            LocalDate.of(2026, 1, 1),
            50.0,
            5,
            new PseudoShippingServiceProvider()
    );


    static EBook ebook = new EBook(
            "EB-001",
            "Effective Java",
            "Joshua Bloch",
            30.0,
            LocalDate.of(2026, 1, 1),
            PseudoMailServiceProvider.getPseudoMailServiceProvider()
    );

    public static void main(String[] args) {
        System.out.println("📚 Welcome to the Book Store!");
        setupCustomer();

        while (true) {
            printMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> deposit();
                case 2 -> buyPaperBook();
                case 3 -> buyEBook();
                case 4 -> {
                    System.out.println("👋 Exiting the store. Goodbye!");
                    return;
                }
                default -> System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }

    private static void setupCustomer() {
        System.out.println("Enter your name:");
        String name = scanner.nextLine();

        System.out.println("Enter your address:");
        String address = scanner.nextLine();

        System.out.println("Enter your phone:");
        String phone = scanner.nextLine();

        System.out.println("Enter your email:");
        String email = scanner.nextLine();

        customer = new Customer(name, address, phone, email);
        System.out.println("✅ Customer created successfully!\n");
    }

    private static void printMenu() {
        System.out.println("\n======== MENU ========");
        System.out.println("1. Deposit Balance");
        System.out.println("2. Buy Paper Book");
        System.out.println("3. Buy EBook");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = Double.parseDouble(scanner.nextLine());
        paymentService.refund(customer, amount);
        System.out.println("✅ Balance added!");
    }

    private static void buyPaperBook() {
        System.out.println("\n📖 Selected: " + paperBook.getBookName() + " | Price: $" + paperBook.getPrice());
        System.out.print("Enter quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());

        try {
            double totalCost = paperBook.buy(qty, customer);
            boolean charged = customer.getPayment().charge(customer, totalCost);

            if (!charged) {
                System.out.println("❌ Not enough balance!");
                return;
            }

            boolean applied = paperBook.ApplyBuy(qty);
            if (applied) {
                paperBook.getShippingInterface().makeShipping(customer, paperBook.getBookName());
                System.out.println("✅ Purchase and shipping successful!");
            } else {
                System.out.println("❌ Failed to apply purchase (maybe stock issue)");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    private static void buyEBook() {
        System.out.println("\n📘 Selected: " + ebook.getBookName() + " | Price: $" + ebook.getPrice());
        System.out.print("Enter quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());

        double totalCost = ebook.buy(qty, customer);
        boolean charged = customer.getPayment().charge(customer, totalCost);

        if (!charged) {
            System.out.println("❌ Not enough balance!");
            return;
        }

        boolean applied = ebook.ApplyBuy(qty);
        if (applied) {
            ebook.getMail().sendMailBuyEmail(customer.getEmail(), "Thank you for buying: " + ebook.getBookName());
            System.out.println("✅ Purchase and email sent successfully!");
        } else {
            System.out.println("❌ Failed to apply purchase.");
        }
    }
}