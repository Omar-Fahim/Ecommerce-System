import java.time.LocalDate;

public class Biscuits extends ExpiringProduct implements Shippable {

    private double weight; // I added weight here and will repeat in each shippable product because Java diamond problem, we can have only single inheritance so we can not have abstract class for shippable

    public Biscuits(String name, double price, int quantity, LocalDate expirationDate, double weight) {
        super(name, price, quantity, expirationDate);
        this.weight = weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean isExpired() {
        return super.isExpired();
    }
}
