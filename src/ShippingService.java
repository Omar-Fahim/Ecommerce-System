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

    private String formatWeight(double grams) {
        if (grams >= 1000) {
            return String.format("%.1fkg", grams / 1000.0);
        } else {
            return String.format("%.0fg", grams);
        }
    }


    public void printShippingDetails(List<Shippable> shippableItems) {

        System.out.println("\n** Shipment notice **");

        if (shippableItems.isEmpty()) {
            System.out.println("No shippable items in the cart.");
            return;
        }

        for (Shippable item : shippableItems) {
            System.out.printf("%dx %-12s %6s\n", ((Product)item).getQuantity(),item.getName(), formatWeight(item.getWeight()));
        }

        System.out.println("Total package weight " + formatWeight(calculateTotalWeight(shippableItems)));



    }






}
