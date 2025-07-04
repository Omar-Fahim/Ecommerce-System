import java.util.List;

public class Customer {

    // Assumption: A customer can have only one cart.

    private String name;
    private double balance;
    private Cart cart;

    public Customer(String name, double balance, Cart cart) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void addToCart(Product product, int quantity) {
        if (cart == null) {
            cart = new Cart();
        }
        cart.addCartItem(product, quantity);
    }

    public void removeFromCart(Product product) {
        if (cart != null) {
            cart.removeCartItem(product);
        }
    }

    public void checkout(){

        if(cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }


        double subtotal = cart.calculateSubTotalPrice();
        ShippingService shippingService = new ShippingService();
        List<Shippable> shippableItems = cart.getShippableItems();
        double shippingFees = shippingService.calculateShippingFees(shippableItems);
        double total = subtotal+ shippingFees;


        if (balance < total) {
            throw new IllegalStateException("Insufficient balance");
        }


        for (CartItem item : cart.getCartItems()) {
            Product product = item.getProduct();
            if (product.isExpired()) {
                throw new IllegalStateException(product.getName() + " is expired.");
            }
            if (!product.isAvailable(item.getQuantity())) {
                throw new IllegalStateException(product.getName() + " is out of stock.");
            }
        }


        for (CartItem item : cart.getCartItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            product.setQuantity(product.getQuantity() - quantity);
        }

        balance -= total;

        shippingService.printShippingDetails(shippableItems);

        printCheckoutReceipt(subtotal, shippingFees, total);


        cart.clearCart();


    }

    private void printCheckoutReceipt(double subtotal, double shipping, double total) {
        System.out.println("\n** Checkout receipt **");
        for (CartItem item : cart.getCartItems()) {
            System.out.printf("%dx %-12s %6.2f\n",
                    item.getQuantity(), item.getProduct().getName(), item.calculateTotalPrice());
        }
        System.out.println("--------------------------");
        System.out.printf("Subtotal     %8.2f\n", subtotal);
        System.out.printf("Shipping     %8.2f\n", shipping);
        System.out.printf("Amount       %8.2f\n", total);
    }






}
