
package services;

import java.io.*;
import java.util.*;

public class patient_service {

    static Scanner sc = new Scanner(System.in);

    public static void add_patient() {
        System.out.print("Enter patient ID: ");
        String id = sc.nextLine().trim();

        System.out.print("Enter patient Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter patient illness: ");
        String illness = sc.nextLine().trim();

        System.out.print("Enter Doctor ID assigned to the patient: ");
        String doctorID = sc.nextLine().trim();

        if (id.isEmpty() || name.isEmpty() || illness.isEmpty() || doctorID.isEmpty()) {
            System.out.println("All fields are required.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("patient.txt", true))) {
            bw.write(id + "," + name + "," + illness + "," + doctorID);
            bw.newLine();

            System.out.println("Patient added successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void view_patient() {
        try (BufferedReader br = new BufferedReader(new FileReader("patient.txt"))) {
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] patient = line.split(",", -1);

                if (patient.length == 4) {
                    System.out.println("\nPatient ID: " + patient[0]);
                    System.out.println("Patient Name: " + patient[1]);
                    System.out.println("Illness: " + patient[2]);
                    System.out.println("Assigned Doctor ID: " + patient[3]);

                    found = true;
                }
            }

            if (!found) {
                System.out.println("No patient records found.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void edit_patient() {
        System.out.print("Enter patient ID to edit: ");
        String id = sc.nextLine().trim();

        ArrayList<String> patients = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader("patient.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] patient = line.split(",", -1);

                if (patient.length == 4 && patient[0].trim().equalsIgnoreCase(id)) {
                    found = true;

                    System.out.print("Enter new patient Name: ");
                    String name = sc.nextLine().trim();

                    System.out.print("Enter new patient illness: ");
                    String illness = sc.nextLine().trim();

                    System.out.print("Enter new Doctor ID: ");
                    String doctorID = sc.nextLine().trim();

                    if (name.isEmpty() || illness.isEmpty() || doctorID.isEmpty()) {
                        System.out.println("All fields are required. Edit cancelled.");
                        return;
                    }

                    line = id + "," + name + "," + illness + "," + doctorID;
                }

                patients.add(line);
            }

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            return;
        }

        if (!found) {
            System.out.println("Patient ID not found.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("patient.txt"))) {
            for (String patient : patients) {
                bw.write(patient);
                bw.newLine();
            }

            System.out.println("Patient updated successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void delete_patient() {
        System.out.print("Enter patient ID to delete: ");
        String id = sc.nextLine().trim();

        ArrayList<String> patients = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader("patient.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] patient = line.split(",", -1);

                if (patient.length == 4 && patient[0].trim().equalsIgnoreCase(id)) {
                    found = true;
                } else {
                    patients.add(line);
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            return;
        }

        if (!found) {
            System.out.println("Patient ID not found.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("patient.txt"))) {
            for (String patient : patients) {
                bw.write(patient);
                bw.newLine();
            }

            System.out.println("Patient deleted successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
