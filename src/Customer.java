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








}
