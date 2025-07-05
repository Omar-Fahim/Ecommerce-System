package Concrete_Classes;

import java.time.LocalDate;
import Models.Product;
import Interfaces.Shippable;
public class Shippable_and_ExpirableProduct extends Product implements Shippable {

    private double weight;
    private LocalDate expirationDate;

    public Shippable_and_ExpirableProduct(String name, double price, int quantity, double weight, LocalDate expirationDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expirationDate = expirationDate;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean isExpired() {
        LocalDate today = LocalDate.now();
        return expirationDate.isBefore(today);
    }
}
