package Factories;

import Concrete_Classes.ExpiringProduct;
import Concrete_Classes.NormalProduct;
import Concrete_Classes.ShippableProduct;
import Concrete_Classes.Shippable_and_ExpirableProduct;
import Models.Product;

import java.time.LocalDate;

public class ProductFactory {

    public static Product createNormalProduct(String name, double price, int quantity) {
        return new NormalProduct(name, price, quantity);
    }

    public static Product createExpiringProduct(String name, double price, int quantity, LocalDate expirationDate) {
            return new ExpiringProduct(name, price, quantity, expirationDate);
    }

    public static Product createShippableProduct(String name, double price, int quantity, double weight) {
            return new ShippableProduct(name, price, quantity, weight);
    }

    public static Product createShippableExpirableProduct(String name, double price, int quantity, double weight, LocalDate expirationDate) {
            return new Shippable_and_ExpirableProduct(name, price, quantity, weight, expirationDate);
    }

}
