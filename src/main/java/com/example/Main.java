package com.example;

import com.example.Model.Customer;
import com.example.Model.Product;
import com.example.Service.CartService;
import com.example.Service.CheckoutService;

public class Main {
    public static void main(String[] args) {
        // Create products
        Product cheese = new Product("Cheese", 100, 10, true, false, 0.2, true);
        Product biscuits = new Product("Biscuits", 150, 5, true, false, 0.7, true);
        Product tv = new Product("TV", 5000, 3, false, false, 5.0, true);
        Product scratchCard = new Product("Scratch Card", 50, 20, false, false, 0.0, false);

        // Create new customer
        Customer customer = new Customer("Jana", 1000);

        // Initialize services
        CartService cartService = new CartService();
        CheckoutService checkoutService = new CheckoutService();

        // user adding to cart
        cartService.addToCart(cheese, 2);
        cartService.addToCart(biscuits, 1);
        cartService.addToCart(scratchCard, 1);

        // Checkout
        checkoutService.checkout(customer, cartService.getCartItems());
    }
}
