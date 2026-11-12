package com.example.maven_github_demo;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String, Product> cart = new HashMap<>();

    // Product class
    static class Product {
        String name;
        int quantity;
        double price;

        Product(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }
    }

    // Add product
    public void addProduct(String name, int quantity, double price) {

        if (name == null || name.trim().isEmpty()
                || quantity <= 0 || price <= 0) {
            throw new IllegalArgumentException("Invalid product details");
        }

        if (cart.containsKey(name)) {
            Product product = cart.get(name);

            if (product.price != price) {
                throw new IllegalArgumentException("Price mismatch");
            }

            product.quantity += quantity;
        } else {
            cart.put(name, new Product(name, quantity, price));
        }
    }

    // Remove product
    public void removeProduct(String name) {

        if (!cart.containsKey(name)) {
            throw new IllegalArgumentException("Product not found");
        }

        cart.remove(name);
    }

    // Calculate total
    public double calculateTotal() {

        double total = 0;

        for (Product product : cart.values()) {
            total += product.quantity * product.price;
        }

        return total;
    }

    // Apply percentage discount
    public double applyDiscount(double percentage) {

        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Invalid discount");
        }

        double total = calculateTotal();

        return total - (total * percentage / 100);
    }

    // Main method
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 2, 50000);
        cart.addProduct("Mouse", 2, 500);

        System.out.println("===== SHOPPING CART =====");

        System.out.println("Total Price: " + cart.calculateTotal());

        System.out.println("After 10% Discount: "
                + cart.applyDiscount(10));

        cart.removeProduct("Mouse");

        System.out.println("After Removing Mouse: "
                + cart.calculateTotal());
    }
}
