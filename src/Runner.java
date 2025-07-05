import java.time.LocalDate;

public class Runner {


    public static void main(String []args) {

        Customer c1 = new Customer("Omar Shaaban",15000);
        Product p1 = new Cheese("Cheese", 100, 5, LocalDate.of(2025, 7, 30),200 );
        Product p2 = new Biscuits("Biscuits", 150, 5, LocalDate.of(2025, 7, 30) ,700);

        c1.addToCart(p1,2);
        c1.addToCart(p2,1);
        c1.checkout();

    }

}
