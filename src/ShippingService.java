import java.util.List;

public class ShippingService {


    public double calculateTotalWeight(List<Shippable> shippableItems) {

        if (shippableItems == null || shippableItems.isEmpty()) {
            return 0.0;
        }
        double totalWeight = 0.0;

        for (Shippable item : shippableItems) {
                totalWeight += item.getWeight();
        }
        return totalWeight;
    }



    public double calculateShippingFees(List<Shippable> shippableItems) {

        double totalWeight = calculateTotalWeight(shippableItems);
        return (totalWeight/1000) * 1.25;
    }



}
