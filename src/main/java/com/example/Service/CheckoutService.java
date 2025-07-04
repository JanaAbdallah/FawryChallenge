package com.example.Service;

import com.example.Model.*;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    private ShippingService shippingService = new ShippingService();
    private static final double SHIPPING_FEE = 30;

    public void checkout(Customer customer, List<CartItem> cartItems) {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        double subtotal = 0;
        List<Shippable> toShip = new ArrayList<>();

        for (CartItem item : cartItems) {
            Product product = item.getProduct();
            int qty = item.getQuantity();

            if (product.isExpired()) {
                System.out.println("Product expired: " + product.getName());
                return;
            }

            if (qty > product.getQuantity()) {
                System.out.println("Out of stock: " + product.getName());
                return;
            }

            if (product.isShippable()) {
                subtotal += item.getTotalPrice();

                for (int i = 0; i < qty; i++) {
                    Product p = product;
                    toShip.add(new Shippable() {
                        public String getName() { return p.getName(); }
                        public double getWeight() { return p.getWeight(); }
                    });
                }
            }

        }

        double shipping = toShip.isEmpty() ? 0 : SHIPPING_FEE;
        double total = subtotal + shipping;

        if (customer.getBalance() < total) {
            System.out.println("Insufficient balance.");
            return;
        }

        // Deduct balance & reduce stock
        customer.deduct(total);
        for (CartItem item : cartItems) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        // Print shipment
        if (!toShip.isEmpty()) {
            shippingService.ship(toShip);
            System.out.println();
        }

        // Print receipt
        System.out.println("** Checkout receipt **");
        for (CartItem item : cartItems) {
            if (item.getProduct().isShippable()) {
                System.out.printf("%dx %-13s %.0f%n", item.getQuantity(), item.getProduct().getName(), item.getTotalPrice());
            }
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal         %.0f%n", subtotal);
        if (shipping > 0)
            System.out.printf("Shipping         %.0f%n", shipping);
        System.out.printf("Amount           %.0f%n", total);
    }
}
