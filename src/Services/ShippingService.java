package Services;

import Interfaces.Shippable;

import java.util.Map;

public class ShippingService {


    public double calculateTotalWeight(Map<Shippable, Integer> shippableItems ) {

        if (shippableItems == null || shippableItems.isEmpty()) {
            return 0.0;
        }
        double totalWeight = 0.0;

        for (Map.Entry<Shippable, Integer> entry : shippableItems.entrySet()) {
            Shippable item = entry.getKey();
            int quantity = entry.getValue();
            totalWeight += item.getWeight() * quantity;
        }
        return totalWeight;


    }



    public double calculateShippingFees(Map<Shippable, Integer> shippableItems) {

        double totalWeight = calculateTotalWeight(shippableItems);
        return (totalWeight*30) /1100;
    }

    private String formatWeight(double grams) {
        if (grams >= 1000) {
            return String.format("%.1fkg", grams / 1000.0);
        } else {
            return String.format("%.0fg", grams);
        }
    }


    public void printShippingDetails(Map<Shippable, Integer> shippableItems) {

        System.out.println("\n** Shipment notice **");

        if (shippableItems.isEmpty()) {
            System.out.println("No shippable items in the cart.");
            return;
        }


        for (Map.Entry<Shippable, Integer> entry : shippableItems.entrySet()) {

            Shippable item = entry.getKey();
            System.out.printf("%dx %-12s %6s\n", entry.getValue(),item.getName(), formatWeight(entry.getValue()* item.getWeight()));

        }
        System.out.println("Total package weight " + formatWeight(calculateTotalWeight(shippableItems)));



    }







}
