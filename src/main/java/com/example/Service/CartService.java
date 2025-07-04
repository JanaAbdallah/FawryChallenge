package com.example.Service;

import com.example.Model.CartItem;
import com.example.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    private List<CartItem> cart = new ArrayList<>();

    public void addToCart(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            System.out.println("Not enough stock for " + product.getName());
            return;
        }
        cart.add(new CartItem(product, quantity));
    }

    public List<CartItem> getCartItems() {
        return cart;
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }

    public void clear() {
        cart.clear();
    }
}
