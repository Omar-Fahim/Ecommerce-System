package Models;

import java.util.*;
import Interfaces.Shippable;
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
            throw new IllegalArgumentException("Models.Product is not available in the requested quantity.");
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

    public Map<Shippable, Integer> getShippableItems() {
        Map<Shippable, Integer> shippableMap = new LinkedHashMap<>();

        for (CartItem item : cartItems) {
            Product product = item.getProduct();

            if (product instanceof Shippable) {
                Shippable shippableProduct = (Shippable) product;
                int quantity = item.getQuantity();

                shippableMap.put(shippableProduct,
                        shippableMap.getOrDefault(shippableProduct, 0) + quantity);
            }
        }

        return shippableMap;
    }



}
