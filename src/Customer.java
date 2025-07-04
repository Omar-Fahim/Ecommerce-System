import java.util.List;

public class Customer {

    // Assumption: A customer can have only one cart.

    private String name;
    private double balance;
    private Cart cart;

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

        if(cart.isEmpty() || cart == null) {
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
        cart.clearCart();




    }






}
