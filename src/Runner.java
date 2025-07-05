import Builders.ProductBuilder;
import Models.Customer;
import Models.Product;

import java.time.LocalDate;

public class Runner {


    public static void main(String []args) {

        Customer c1 = new Customer("Omar Shaaban", 15000);
        Product p1 = new ProductBuilder()
                .setName("Cheese")
                .setPrice(100)
                .setQuantity(5)
                .setWeight(200)
                .setExpirationDate(LocalDate.of(2025, 7, 30))
                .build();
        Product p2 = new ProductBuilder()
                .setName("Biscuits")
                .setPrice(150)
                .setQuantity(5)
                .setWeight(700)
                .setExpirationDate(LocalDate.of(2025, 7, 30))
                .build();

        c1.addToCart(p1, 2);
        c1.addToCart(p2, 1);
        c1.checkout();

    }

}
