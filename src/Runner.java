import Factories.ProductFactory;
import Models.Customer;
import Models.Product;

import java.time.LocalDate;

public class Runner {


    public static void main(String []args) {

        Customer c1 = new Customer("Omar Shaaban", 15000);
        Product p1 = ProductFactory.createShippableExpirableProduct("Cheese", 100, 5,  200,LocalDate.of(2025, 7, 30));
        Product p2 = ProductFactory.createShippableExpirableProduct("Biscuits", 150, 5, 700,LocalDate.of(2025, 7, 30));

        c1.addToCart(p1, 2);
        c1.addToCart(p2, 1);
        c1.checkout();

    }

}
