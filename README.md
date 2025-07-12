# Quantum Bookstore Console App

An interactive Java console application simulating an online bookstore. It allows customers to browse and purchase books, manage inventory, and simulate payments. This project was built for educational purposes and demonstrates key OOP principles, such as inheritance, encapsulation, and polymorphism.

## Features

* Book types: `PaperBook`, `EBook`, and `DemoBook`
* Customer management
* Purchase simulation with basic payment handling
* Inventory management (including outdate check)
* Console-based interaction

## Project Structure

```plaintext
C:.
|   Main.java
|   
+---model
|   +---Book
|   |       Book.java
|   |       DemoBook.java
|   |       EBook.java
|   |       PaperBook.java
|   |       
|   +---Customer
|   |   |   Customer.java
|   |   |   
|   |   +---order
|   |   |       Order.java
|   |   |       OrderStatus.java
|   |   |
|   |   \---payment
|   |           PaymentInterface.java
|   |           PseudoPaymentService.java
|   |
|   +---Mail
|   |       MailInterface.java
|   |       PseudoMailServiceProvider.java
|   |
|   \---Shipping
|           PseudoShippingServiceProvider.java
|           ShippingInterface.java
|
\---Service
        BookSellingService.java
        CustomerService.java
        InventoryService.java
```

## How to Run

1. Compile the project using your favorite IDE (like IntelliJ IDEA or Eclipse) or `javac` from the command line.
2. Run `Main.java` to launch the console-based application.
3. Follow the on-screen prompts to:

    * View books
    * Make purchases
    * Check customer data

## JAR Executable

You can download the compiled `.jar` file here:
👉 [Download JAR](#) *(Put link here after uploading to GitHub Releases or other hosting platform)*

To run the JAR:

```bash
  java -jar QuantumBookstore.jar
```

## Technologies Used

* Java 17+
* Standard Java Libraries

## Example Interaction

```
==== Welcome to Quantum Bookstore ====
1. View Available Books
2. Buy a Book
3. View Customer Orders
4. Exit
Choose option: 1

>> Book List:
- ISBN: 12345 | PaperBook: Java for Beginners | Author: John Doe | Available: 5 copies
...
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT License](LICENSE)

---