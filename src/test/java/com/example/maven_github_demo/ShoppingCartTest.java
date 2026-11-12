package com.example.maven_github_demo;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {

    @Test
    void testAddProduct() {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 2, 50000);

        assertEquals(100000, cart.calculateTotal(), 0.001);
    }

    @Test
    void testRemoveProduct() {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Mouse", 2, 500);

        cart.removeProduct("Mouse");

        assertEquals(0, cart.calculateTotal(), 0.001);
    }

    @Test
    void testTotalCalculation() {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 1, 50000);
        cart.addProduct("Mouse", 2, 500);

        assertEquals(51000, cart.calculateTotal(), 0.001);
    }

    @Test
    void testDiscount() {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 1, 50000);

        assertEquals(45000, cart.applyDiscount(10), 0.001);
    }

    @Test
    void testInvalidQuantity() {
        ShoppingCart cart = new ShoppingCart();

        assertThrows(IllegalArgumentException.class,
            () -> cart.addProduct("Laptop", 0, 50000));
    }

    @Test
    void testInvalidPrice() {
        ShoppingCart cart = new ShoppingCart();

        assertThrows(IllegalArgumentException.class,
            () -> cart.addProduct("Laptop", 1, -500));
    }

    @Test
    void testInvalidDiscount() {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 1, 50000);

        assertThrows(IllegalArgumentException.class,
            () -> cart.applyDiscount(110));
    }
}

