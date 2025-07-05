
# Ecommerce-System

A Java-based e-commerce system implementing core features such as product management, a shopping cart, checkout, and shipping logic. The project utilizes OOP principles, several design patterns, and modular architecture for maintainability and extensibility.

---

## Table of Contents

- [Features](#features)
- [Architecture & Design Patterns](#architecture--design-patterns)
- [Techniques Used](#techniques-used)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Usage Example](#usage-example)
- [Sample Output](#sample-output)
- [Contributing](#contributing)
- [Contact](#contact)

---

## Features

- **Product Management**: Add, edit, and remove products (including expirable and shippable items).
- **Shopping Cart**: Customers can add items to their cart and manage quantities.
- **Checkout Process**: Handles payment, validates stock and customer balance.
- **Shipping Logic**: Calculates shipping fees based on product weight.
- **Receipt Generation**: Prints detailed shipment notices and receipts.

---

## Architecture & Design Patterns

This project utilizes several well-known design patterns and architecture principles:

- **Factory Pattern**  
  Used in the `ProductFactory` class to encapsulate object creation logic for different product types (shippable, expirable, etc.).
- **Interface-Based Programming**  
  Key behaviors (e.g., shippable, expirable) are defined as interfaces, supporting open-closed design.
- **Separation of Concerns & Modularity**  
  The codebase is organized into packages like `Models`, `Services`, `Interfaces`, `Factories`, and `Concrete_Classes`.

---

## Techniques Used

- **Object-Oriented Programming (OOP)**
- **Java 8+ Features**: Lambda expressions, streams, and the improved Date/Time API (`LocalDate`).
- **Clear Layering**: Entities, business logic, and utilities are separated for clarity and maintainability.
- **Input Validation**: Ensures data integrity during checkout and shipping.
- **Extensible Product Model**: Supports various product types via interfaces and factories.

---

## Project Structure

```
Ecommerce-System/
├── .gitattributes
├── .gitignore
├── README.md
├── src/
│   ├── Concrete_Classes/
│   ├── Factories/
│   ├── Interfaces/
│   ├── Models/
│   ├── Services/
│   └── Runner.java
└── .idea/
```

---

## Getting Started

### Prerequisites

- Java JDK 8 or higher

### Compilation & Running

```sh
git clone https://github.com/Omar-Fahim/Ecommerce-System.git
cd Ecommerce-System
javac -d out/production/Ecommerce-System src/**/*.java
java -cp out/production/Ecommerce-System Runner
```

---

## Usage Example

Here is a sample code demonstrating the primary features:

```java
import java.time.LocalDate;

public class Runner {
    public static void main(String[] args) {
        Customer c1 = new Customer("Omar Shaaban", 15000);
        Product p1 = ProductFactory.createShippableExpirableProduct(
            "Cheese", 100, 5, 200, LocalDate.of(2025, 7, 30)
        );
        Product p2 = ProductFactory.createShippableExpirableProduct(
            "Biscuits", 150, 5, 700, LocalDate.of(2025, 7, 30)
        );

        c1.addToCart(p1, 2);
        c1.addToCart(p2, 1);
        c1.checkout();
    }
}
```

---

## Sample Output

```
** Shipment notice **
2x Cheese         400g
1x Biscuits       700g
Total package weight 1.1kg

** Checkout receipt **
2x Cheese       200.00
1x Biscuits     150.00
--------------------------
Subtotal       350.00
Shipping        30.00
Amount         380.00
```

---

## Contributing

Contributions are welcome! Please fork the repository and submit pull requests for improvements or bug fixes.

---

## Contact

- **Author:** [Omar Fahim](https://github.com/Omar-Fahim)
- **Email:** [omar_shaaban@outlook.com]

---
