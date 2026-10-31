
package services;

import java.io.*;
import java.util.*;

public class medical_service {

    static Scanner sc = new Scanner(System.in);

    public static void add_medical() {
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("medical.txt", true))) {

            System.out.print("Record ID: ");
            String recordID = sc.nextLine();

            System.out.print("Patient ID: ");
            String patientID = sc.nextLine();

            System.out.print("Doctor ID: ");
            String doctorID = sc.nextLine();

            System.out.print("Date (YYYY-MM-DD): ");
            String date = sc.nextLine();

            System.out.print("Diagnosis: ");
            String diagnosis = sc.nextLine();

            System.out.print("Treatment: ");
            String treatment = sc.nextLine();

            System.out.print("Prescription: ");
            String prescription = sc.nextLine();

            System.out.print("Notes: ");
            String notes = sc.nextLine();

            bw.write(recordID + "," + patientID + "," + doctorID + "," + date + "," + diagnosis + "," + treatment + "," + prescription + "," + notes);
            bw.newLine();

            System.out.println("Medical record added successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void view_medical() {
        try (BufferedReader br = new BufferedReader(
                new FileReader("medical.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] record = line.split(",", -1);

                if (record.length == 8) {
                    System.out.println("\nRecord ID: " + record[0]);
                    System.out.println("Patient ID: " + record[1]);
                    System.out.println("Doctor ID: " + record[2]);
                    System.out.println("Date: " + record[3]);
                    System.out.println("Diagnosis: " + record[4]);
                    System.out.println("Treatment: " + record[5]);
                    System.out.println("Prescription: " + record[6]);
                    System.out.println("Notes: " + record[7]);
                    System.out.println("------------------------------");
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void edit_medical() {
        ArrayList<String> records = new ArrayList<>();

        System.out.print("Enter Record ID to edit: ");
        String searchID = sc.nextLine();

        boolean found = false;

        try (BufferedReader br = new BufferedReader(
                new FileReader("medical.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] record = line.split(",", -1);

                if (record.length == 8
                        && record[0].trim().equalsIgnoreCase(searchID)) {

                    found = true;

                    System.out.print("New Patient ID: ");
                    record[1] = sc.nextLine();

                    System.out.print("New Doctor ID: ");
                    record[2] = sc.nextLine();

                    System.out.print("New Date (YYYY-MM-DD): ");
                    record[3] = sc.nextLine();

                    System.out.print("New Diagnosis: ");
                    record[4] = sc.nextLine();

                    System.out.print("New Treatment: ");
                    record[5] = sc.nextLine();

                    System.out.print("New Prescription: ");
                    record[6] = sc.nextLine();

                    System.out.print("New Notes: ");
                    record[7] = sc.nextLine();

                    line = String.join(",", record);
                }

                records.add(line);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        if (!found) {
            System.out.println("Medical record not found.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("medical.txt"))) {

            for (String record : records) {
                bw.write(record);
                bw.newLine();
            }

            System.out.println("Medical record updated successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void delete_medical() {
        ArrayList<String> records = new ArrayList<>();

        System.out.print("Enter Record ID to delete: ");
        String searchID = sc.nextLine();

        boolean found = false;

        try (BufferedReader br = new BufferedReader(
                new FileReader("medical.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] record = line.split(",", -1);

                if (record.length == 8
                        && record[0].trim().equalsIgnoreCase(searchID)) {
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
            System.out.println("Medical record not found.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("medical.txt"))) {

            for (String record : records) {
                bw.write(record);
                bw.newLine();
            }

            System.out.println("Medical record deleted successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
