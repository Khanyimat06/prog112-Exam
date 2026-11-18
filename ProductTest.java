package com.mycompany.productapp;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */



import org.junit.jupiter.api.Test; // JUnit test
import static org.junit.jupiter.api.Assertions.*; // To use assertEquals

/**
 *
 * @author Student
 */
public class ProductTest {

    // Test 1: Check if total is correct. Should be 153.
    @Test
    public void testTotal() {
        // Set up test data
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20}};
        // Create Product object with test data
        Product p = new Product(names, sales);
        // Check: Expected = 153, Actual = what method returns
        assertEquals(153, p.GetTotalProductsSold());
    }

    // Test 2: Check if average is correct. Should be 17.0 (153 / 9)
    @Test
    public void testAverage() {
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20}};
        Product p = new Product(names, sales);
        // 0.01 allows a tiny difference for decimals
        assertEquals(17.0, p.GetAverageProductSold(), 0.01);
    }

    // Test 3: Check if most popular is correct. Cozy Nights Monarch total = 63
    @Test
    public void testMostPopular() {
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20}};
        Product p = new Product(names, sales);
        assertEquals("Cozy Nights Monarch (63)", p.GetMostPopularProduct());
    }
}