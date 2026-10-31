
package services;

import java.util.*;
import java.io.*;

public class billing_service {

    static Scanner sc = new Scanner(System.in);

    public static void add_billing() {
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("billing.txt", true))) {

            System.out.print("Billing ID: ");
            String billingID = sc.nextLine();

            System.out.print("Patient ID: ");
            String patientID = sc.nextLine();

            System.out.print("Amount: ");
            String amount = sc.nextLine();

            System.out.print("Payment Status (Paid/Unpaid): ");
            String status = sc.nextLine();

            System.out.print("Payment Date (YYYY-MM-DD): ");
            String date = sc.nextLine();

            bw.write(billingID + "," + patientID + "," + amount + ","
                    + status + "," + date);
            bw.newLine();

            System.out.println("Billing record added successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void view_billing() {
        try (BufferedReader br = new BufferedReader(
                new FileReader("billing.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] bill = line.split(",", -1);

                if (bill.length == 5) {
                    System.out.println("\nBilling ID: " + bill[0]);
                    System.out.println("Patient ID: " + bill[1]);
                    System.out.println("Amount: " + bill[2]);
                    System.out.println("Payment Status: " + bill[3]);
                    System.out.println("Payment Date: " + bill[4]);
                    System.out.println("------------------------------");
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void edit_billing() {
        ArrayList<String> records = new ArrayList<>();

        System.out.print("Enter Billing ID to edit: ");
        String searchID = sc.nextLine();

        boolean found = false;

        try (BufferedReader br = new BufferedReader(
                new FileReader("billing.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] bill = line.split(",", -1);

                if (bill.length == 5
                        && bill[0].trim().equalsIgnoreCase(searchID)) {

                    found = true;

                    System.out.print("New Patient ID: ");
                    bill[1] = sc.nextLine();

                    System.out.print("New Amount: ");
                    bill[2] = sc.nextLine();

                    System.out.print("New Payment Status (Paid/Unpaid): ");
                    bill[3] = sc.nextLine();

                    System.out.print("New Payment Date (YYYY-MM-DD): ");
                    bill[4] = sc.nextLine();

                    line = String.join(",", bill);
                }

                records.add(line);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        if (!found) {
            System.out.println("Billing record not found.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("billing.txt"))) {

            for (String record : records) {
                bw.write(record);
                bw.newLine();
            }

            System.out.println("Billing record updated successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void delete_billing() {
        ArrayList<String> records = new ArrayList<>();

        System.out.print("Enter Billing ID to delete: ");
        String searchID = sc.nextLine();

        boolean found = false;

        try (BufferedReader br = new BufferedReader(
                new FileReader("billing.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] bill = line.split(",", -1);

                if (bill.length == 5
                        && bill[0].trim().equalsIgnoreCase(searchID)) {
                    found = true;
                } else {
                    records.add(line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        if (!found) {
            System.out.println("Billing record not found.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("billing.txt"))) {

            for (String record : records) {
                bw.write(record);
                bw.newLine();
            }

            System.out.println("Billing record deleted successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
