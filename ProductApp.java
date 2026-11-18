/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productapp;
import java.io.FileWriter;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class ProductApp {
public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get data from user
        System.out.print("Enter Customer Name: ");
        String customerName = input.nextLine();

        System.out.println("Select Product:");
        System.out.println("1. Cozy Nights Monarch");
        System.out.println("2. Restonic Barbados");
        System.out.println("3. Sealy Phuket");
        System.out.print("Enter choice (1-3): ");
        int choice = input.nextInt();

        String product = "";
        if (choice == 1) {
            product = "Cozy Nights Monarch";
        } else if (choice == 2) {
            product = "Restonic Barbados";
        } else if (choice == 3) {
            product = "Sealy Phuket";
        } else {
            product = "Unknown Product";
        }

   
    }

interface IProductCalculations {
    double GetVat();
    double GetCommission();
    double GetTotal();
}

// 2. CALCULATIONS CLASS
class ProductCalculations implements IProductCalculations {
    double price;

    public ProductCalculations(double price) {
        this.price = price;
    }

    public double GetVat() {
        return price * 0.15;
    }

    public double GetCommission() {
        return price * 0.05;
    }

    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}

// 3. MAIN - NO GUI, JUST CONSOLE
public class Productapp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get data from user
        System.out.print("Enter Customer Name: ");
        String customerName = input.nextLine();

        System.out.println("Select Product:");
        System.out.println("1. Cozy Nights Monarch");
        System.out.println("2. Restonic Barbados");
        System.out.println("3. Sealy Phuket");
        System.out.print("Enter choice (1-3): ");
        int choice = input.nextInt();

        String product = "";
        if (choice == 1) {
            product = "Cozy Nights Monarch";
        } else if (choice == 2) {
            product = "Restonic Barbados";
        } else if (choice == 3) {
            product = "Sealy Phuket";
        } else {
            product = "Unknown Product";
        }

        System.out.print("Enter Price: ");
        double price = input.nextDouble();

        // Do calculations
        ProductCalculations calc = new ProductCalculations(price);
        double vat = calc.GetVat();
        double commission = calc.GetCommission();
        double total = calc.GetTotal();

        // Show on screen - like the popup
        System.out.println("\n--- Message ---");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Product: " + product);
        System.out.println("VAT: R " + vat);
        System.out.println("COMMISSION: R " + commission);
        System.out.println("TOTAL: R " + total);

        // Save to data.txt
        try {
            FileWriter writer = new FileWriter("data.txt", true);
            writer.write("DATA LOG\n");
            writer.write("***************************\n");
            writer.write("Customer Name: " + customerName + "\n");
            writer.write("Product: " + product + "\n");
            writer.write("VAT: R " + vat + "\n");
            writer.write("COMMISSION: R " + commission + "\n");
            writer.write("TOTAL: R " + total + "\n");
            writer.write("***************************\n");
            writer.close();
            System.out.println("\nSaved to data.txt");
        } catch (Exception e) {
            System.out.println("Error writing file");
        }

        input.close();
    }
}
