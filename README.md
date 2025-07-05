# 🛒 Ecommerce-System

A Java-based e-commerce system with core features like product management, shopping cart, checkout, and shipping. Designed with OOP principles, design patterns, and a modular structure for clean, maintainable code.

---

## 📑 Table of Contents

- Features
- Architecture & Design Patterns
- Techniques Used
- Project Structure
- Getting Started
-Demo Scenarios
- Contributing
- Contact
---
## ✨ Features

- **Product Management**: Create, edit, and remove products (normal, expirable, shippable, or both).  
- **Shopping Cart**: Customers can add products, adjust quantities, and remove items.  
- **Checkout Process**: Validates stock levels, checks customer balance, and finalizes purchases.  
- **Shipping Logic**: Calculates shipping fees based on total weight.  
- **Receipts**: Prints detailed shipment notices and receipts after checkout.  

---
## 🏗️ Architecture & Design Patterns

This project applies several design patterns and clean architecture principles:

- **Builder Pattern**  
  Used in `ProductBuilder` to create complex products with optional attributes like weight and expiration date.  
- **Interfaces**  
  Defines key behaviors (e.g., `Shippable`, `Expirable`) to support open-closed design.  
- **Modular Design**  
  Code organized into packages like `Models`, `Services`, `Interfaces`, `Builders`, and `Concrete_Classes` for better separation of concerns.  

---

## 💻 Techniques Used

- Object-Oriented Programming (OOP)  
- Java 8+ features: lambda expressions, streams, and `LocalDate` API.  
- Input validation during cart updates and checkout.  
- Extensible product model supporting multiple types via builder and interfaces.  

---

## 📁 Project Structure

```
Ecommerce-System/
├── .gitattributes
├── .gitignore
├── README.md
├── src/
│   ├── Builders/
│   │   └── ProductBuilder.java
│   ├── Concrete_Classes/
│   │   ├── ExpiringProduct.java
│   │   ├── NormalProduct.java
│   │   ├── ShippableProduct.java
│   │   └── Shippable_and_ExpirableProduct.java
│   ├── Interfaces/
│   │   └── Shippable.java
│   ├── Models/
│   │   ├── Cart.java
│   │   ├── CartItem.java
│   │   ├── Customer.java
│   │   └── Product.java
│   ├── Services/
│   │   └── ShippingService.java
│   └── Runner.java
└── .idea/

```

---

## Getting Started

### Prerequisites

- Java JDK 8 or higher

### Compilation & Running

### 📥 Clone the Repository

```bash
git clone https://github.com/Omar-Fahim/Ecommerce-System.git
```

### 📂 Navigate to the Project Folder

```bash
cd Ecommerce-System
```

### 🛠️ Compile the Source Code

```bash
javac -d out/production/Ecommerce-System src/**/*.java
```

### 🚀 Run the Application

```bash
java -cp out/production/Ecommerce-System Runner
```

---

## 📖 Scenario 1 (Shippable Items)

```java
Customer c1 = new Customer("Omar Shaaban", 15000);
Product p1 = new ProductBuilder("Cheese", 100, 5)
                .setWeight(200)
                .setExpirationDate(LocalDate.of(2025, 7, 30))
                .build();

Product p2 = new ProductBuilder("Biscuits", 150, 5)
                .setWeight(700)
                .setExpirationDate(LocalDate.of(2025, 7, 30))
                .build();

c1.addToCart(p1, 2);
c1.addToCart(p2, 1);
c1.checkout();
```

---

## 📝 Sample Output 1

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

## 📖 Scenario 2 (No Shippable Items)

```java
Customer c1 = new Customer("Omar Shaaban", 15000);
Product p1 = new ProductBuilder("Bread", 100, 5)
                .setExpirationDate(LocalDate.of(2025, 7, 30))
                .build();

Product p2 = new ProductBuilder("Cucumbers", 150, 5)
                .setExpirationDate(LocalDate.of(2025, 7, 30))
                .build();

c1.addToCart(p1, 2);
c1.addToCart(p2, 1);
c1.checkout();
```

---

## 📝 Sample Output 2

```
** Shipment notice **
No shippable items in the cart.

** Checkout receipt **
2x Bread       200.00
1x Cucumbers     150.00
--------------------------
Subtotal       350.00
Shipping         0.00
Amount         350.00
```
-----

## Scenario 3 (Insufficient Balance)
```java
Customer c1 = new Customer("Omar Shaaban", 200);
Product p1 = new ProductBuilder("Ball", 100, 5)
                .build();

Product p2 = new ProductBuilder("T-Shirt", 150, 5)
                .build();

c1.addToCart(p1, 2);
c1.addToCart(p2, 1);
c1.checkout();
```
---
## Sample Output 3
```
Exception in thread "main" java.lang.IllegalStateException: Insufficient balance

```
## Scenario 4 (Cart is Empty)
```java
 Customer c1 = new Customer("Omar Shaaban", 200);
 c1.checkout();
```
---
## Sample Output 4
```
Exception in thread "main" java.lang.IllegalStateException: Models.Cart is empty
```
## Scenario 5 (Product Sold After Being Added to the Cart)
``` java
Customer c1 = new Customer("Omar Shaaban", 600);
Product p1 = new ProductBuilder("Ball", 100, 2)
                .build();
Product p2 = new ProductBuilder("T-Shirt", 150, 1)
                .build();
c1.addToCart(p1, 2);
c1.addToCart(p2, 1);
Customer c2 = new Customer("Omar Shaaban", 500);
c2.addToCart(p1,1);
c1.checkout();
c2.checkout();
```
---
## Sample Output 5
```
** Shipment notice **
No shippable items in the cart.

** Checkout receipt **
2x Ball         200.00
1x T-Shirt      150.00
--------------------------
Subtotal       350.00
Shipping         0.00
Amount         350.00
Exception in thread "main" java.lang.IllegalStateException: Ball is out of stock.
```
---
## Scenario 6 (Can not Add to the Cart More Than the Available Quantity)
```java
  Customer c1 = new Customer("Omar Shaaban", 600);
  Product p1 = new ProductBuilder("Ball", 100, 1)
                .build();
  c1.addToCart(p1, 2);
  c1.checkout();
```
---
## Sample Output 6
```
Exception in thread "main" java.lang.IllegalArgumentException: Models.Product is not available in the requested quantity.
```
## Scenario 7 (Can not Add to the Cart Expired Product)
```java
Customer c1 = new Customer("Omar Shaaban", 600);
Product p1 = new ProductBuilder("Ball", 100, 1)
                .setExpirationDate(LocalDate.of(2020, 1, 1))
                .build();
c1.addToCart(p1, 1);
c1.checkout();
```
---
## Sample Output 7
```
Exception in thread "main" java.lang.IllegalStateException: Ball is expired.
```

## Scenario 8 (Product Expired While in Cart)
```java
Customer c1 = new Customer("Omar Shaaban", 600);
Product p1 = new ProductBuilder("Ball", 100, 1)
                .setExpirationDate(LocalDate.of(2026, 1, 1))
                .build();
c1.addToCart(p1, 1);
((ExpiringProduct)p1).setExpirationDate(LocalDate.of(2020, 1, 1));
c1.checkout();
```
---
## Sample Output 8
```
Exception in thread "main" java.lang.IllegalStateException: Ball is expired.
```

## 🤝 Contributing

Contributions are welcome! Please fork the repository and submit pull requests for improvements or bug fixes.

---

## 📬 Contact

- **Author:** [Omar Fahim](https://github.com/Omar-Fahim)
- **Email:** omar_shaaban@outlook.com

---
