package Builders;

import Models.Product;
import Concrete_Classes.NormalProduct;
import Concrete_Classes.ExpiringProduct;
import Concrete_Classes.ShippableProduct;
import Concrete_Classes.Shippable_and_ExpirableProduct;

import java.time.LocalDate;

public class ProductBuilder {
    private String name;
    private double price;
    private int quantity;
    private Double weight;
    private LocalDate expirationDate;

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public ProductBuilder setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public ProductBuilder setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public Product build() {
        if (weight != null && expirationDate != null) {
            return new Shippable_and_ExpirableProduct(name, price, quantity, weight, expirationDate);
        } else if (weight != null) {
            return new ShippableProduct(name, price, quantity, weight);
        } else if (expirationDate != null) {
            return new ExpiringProduct(name, price, quantity, expirationDate);
        } else {
            return new NormalProduct(name, price, quantity);
        }
    }
}