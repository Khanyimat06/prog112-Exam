/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productssalesreport;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class ProductsSalesReport {
    public static void main(String[] args) {
        // Create a Scanner so we can read what the user types
        Scanner input = new Scanner(System.in);

        // 1D array - store the 3 product names
        String[] productNames = new String[3];
        productNames[0] = "Cozy Nights Monarch";
        productNames[1] = "Restonic Barbados";
        productNames[2] = "Sealy Phuket";

        // 2D array - store sales. 3 products, 3 months each.
        int[][] sales = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) + " for " + productNames[i] + " mattress: ");
                sales[i][j] = input.nextInt();
            }
            System.out.println("");
        }

        // Product Names and Sales
        Product myProduct = new Product(productNames, sales);
        PrintProduct printer = new PrintProduct();

        // We call the methods to get the answers
        int total = myProduct.GetTotalProductsSold();
        double average = myProduct.GetAverageProductSold();
        String mostPopular = myProduct.GetMostPopularProduct();

        // The Print of the final report
        printer.printReport(total, average, mostPopular);

        input.close();
    }
}

interface IProduct {
    int GetTotalProductsSold();
    double GetAverageProductSold();
    String GetMostPopularProduct();
}

// This class does all the calculations. It uses the methods from IProduct.
class Product implements IProduct {
    String[] productNames;
    int[][] sales;

    // It saves the product names and sales into this class so we can use them for future use
    public Product(String[] productNames, int[][] sales) {
        this.productNames = productNames;
        this.sales = sales;
    }

    // We calculate the Total sales
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                total = total + sales[i][j];
            }
        }
        return total;
    }

    // We calculate AVERAGE sales
    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold(); // First get the total using the method above
        double average = total / 9.0; // Use 9.0 so we get a decimal answer, not 17
        return average; // Give the average back to Main
    }

    // Find MOST POPULAR product
    // Most popular = the product with the highest TOTAL sales (all 3 months added)
    @Override
    public String GetMostPopularProduct() {
        int biggest = 0; 
        int position = 0; )

        // Loop through the 3 products
        for (int i = 0; i < 3; i++) {
            int productTotal = 0; 
            for (int j = 0; j < 3; j++) {
                productTotal = productTotal + sales[i][j];
            }
            if (productTotal > biggest) {
                biggest = productTotal; 
                position = i; 
            }
        }
        
        return productNames[position] + " (" + biggest + ")";
    }
}


class PrintProduct {
   
    public void printReport(int total, double average, String mostPopular) {
        System.out.println(""); // Empty line for spacing
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("****************************************");
        System.out.println("TOTAL PRODUCT SALES: " + total);
        System.out.println("AVERAGE PRODUCT SALES: " + average);
        System.out.println("MOST POPULAR PRODUCT: " + mostPopular);
    }
} 

  
