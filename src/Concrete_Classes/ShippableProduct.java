package Concrete_Classes;
import Models.Product;
import Interfaces.Shippable;

public class ShippableProduct extends Product {
    private double weight;


    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

}
