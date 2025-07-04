public class TV extends Product implements Shippable {

    private double weight; // I added weight here and will repeat in each shippable product because Java diamond problem, we can have only single inheritance so we can not have abstract class for shippable

    public TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
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
}
