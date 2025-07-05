package Concrete_Classes;
import Models.Product;
import Interfaces.Shippable;

public class ShippableProduct extends Product implements Shippable {
    private double weight;


    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
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

}
