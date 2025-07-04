import java.util.ArrayList;
import java.util.List;

public class Cart {


    private List<CartItem> cartItems;



    public Cart() {
        this.cartItems = new ArrayList<>();
    }


    public List<CartItem> getCartItems() {
        return cartItems;
    }


    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }


    public void addCartItem(Product product, int quantity) {

        if(!product.isAvailable(quantity)){
            throw new IllegalArgumentException("Product is not available in the requested quantity.");
        }

        for (CartItem item : cartItems) {
            if (item.getProduct().equals(product)) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        CartItem newItem = new CartItem(product, quantity);
        cartItems.add(newItem);
    }


    public void removeCartItem(Product product) {

        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getProduct().equals(product)) {
                cartItems.remove(i);
                break;
            }
        }
    }

    public double calculateSubTotalPrice() {
        double total = 0.0;
        for (CartItem item : cartItems) {
            total += item.calculateTotalPrice();
        }
        return total;
    }

    public void clearCart() {
        cartItems.clear();
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }




}
