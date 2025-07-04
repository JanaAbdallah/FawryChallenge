package com.example.Model;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private boolean expirable;
    private boolean expired;
    private double weight;
    private boolean shippable;

    public Product(String name, double price, int quantity,
                   boolean expirable, boolean expired,
                   double weight, boolean shippable) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expirable = expirable;
        this.expired = expired;
        this.weight = weight;
        this.shippable = shippable;
    }

    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public boolean isExpirable() { return expirable; }
    public boolean isExpired() { return expired; }
    public boolean isShippable() { return shippable; }
    public double getWeight() { return weight; }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }
}
