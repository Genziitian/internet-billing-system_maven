package com.billing;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("=== Internet Data Usage Billing System ===");

        do {
            // 1. Input Customer Details
            System.out.print("\nEnter Customer Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter Account Number: ");
            String accNum = scanner.nextLine();

            // 2. Input Plan Type
            System.out.println("Select Plan Type: (1) Basic  (2) Standard  (3) Premium");
            System.out.print("Enter choice (1-3): ");
            int planChoice = scanner.nextInt();
            
            System.out.print("Enter data consumed this month (in GB): ");
            double dataConsumed = scanner.nextDouble();
            scanner.nextLine(); // Clear scanner buffer

            // 3. Define Plan Configurations
            double baseRate = 0;
            double dataLimitGB = 0;
            double excessRatePerGB = 5.0; // Charge per GB over the limit
            String planName = "";

            switch (planChoice) {
                case 1:
                    planName = "Basic";
                    baseRate = 20.0;    // $20/month
                    dataLimitGB = 10.0; // 10 GB limit
                    break;
                case 2:
                    planName = "Standard";
                    baseRate = 40.0;    // $40/month
                    dataLimitGB = 50.0; // 50 GB limit
                    break;
                case 3:
                    planName = "Premium";
                    baseRate = 70.0;     // $70/month
                    dataLimitGB = 100.0; // 100 GB limit
                    break;
                default:
                    System.out.println("Invalid plan choice. Defaulting to Basic.");
                    planName = "Basic";
                    baseRate = 20.0;
                    dataLimitGB = 10.0;
                    break;
            }

            // 4. Calculate Bill & Extra Charges
            double extraUsage = 0;
            double extraCharge = 0;

            if (dataConsumed > dataLimitGB) {
                extraUsage = dataConsumed - dataLimitGB;
                extraCharge = extraUsage * excessRatePerGB;
            }

            double totalBill = baseRate + extraCharge;

            // 5. Display Result
            System.out.println("\n----- BILLING INVOICE -----");
            System.out.println("Customer Name  : " + name);
            System.out.println("Account Number : " + accNum);
            System.out.println("Plan Subscribed: " + planName);
            System.out.println("Data Consumed  : " + dataConsumed + " GB (Limit: " + dataLimitGB + " GB)");
            if (extraUsage > 0) {
                System.out.printf("Extra Usage    : %.2f GB (Charge: $%.2f)\n", extraUsage, extraCharge);
            }
            System.out.printf("Total Amount Due: $%.2f\n", totalBill);
            System.out.println("---------------------------\n");

            // 6. Loop Option
            System.out.print("Do you want to process another customer? (yes/no): ");
            choice = scanner.nextLine().trim().toLowerCase();

        } while (choice.equals("yes") || choice.equals("y"));

        System.out.println("Thank you for using the Billing System!");
        scanner.close();
    }
}
