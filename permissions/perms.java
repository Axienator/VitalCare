
package permissions;

import java.util.*;
import services.*;

public class perms {

    static Scanner sc = new Scanner(System.in);

    public static void patient_records() {
        System.out.printf("""
            ==================================================
                [1] Create Patient Record
                [2] View Patient Record
                [3] Edit Patient Record
                [4] Delete Patient Record
                [0] Back
            ==================================================
            Enter choice: """);

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> patient_service.add_patient();
            case 2 -> patient_service.view_patient();
            case 3 -> patient_service.edit_patient();
            case 4 -> patient_service.delete_patient();
            case 0 -> {
                System.out.println("Returning to menu...");
            }
            default -> System.out.println("Invalid choice, try again.");
        }
    }

    public static void doctor_management() {
        System.out.printf("""
            ==================================================
                [1] Create Doctor Record
                [2] View Doctor Record
                [3] Edit Doctor Record
                [4] Delete Doctor Record
                [0] Back
            ==================================================
            Enter choice: """);

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> doctor_service.create_doctor();
            case 2 -> doctor_service.view_doctor();
            case 3 -> doctor_service.edit_doctor();
            case 4 -> doctor_service.delete_doctor();
            case 0 -> System.out.println("Returning to menu...");
            default -> System.out.println("Invalid choice, try again.");
        }
    }

    public static void appointments(String doctorID) {
        System.out.printf("""
            ==================================================
                [1] Add Appointment
                [2] View Appointment
                [3] Edit Appointment
                [4] Delete Appointment
                [0] Back
            ==================================================
            Enter choice: """);

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> appointment_service.add_appointment();
            case 2 -> appointment_service.view_appointment(doctorID);
            case 3 -> appointment_service.edit_appointment();
            case 4 -> appointment_service.delete_appointment();
            case 0 -> System.out.println("Returning to menu...");
            default -> System.out.println("Invalid choice, try again.");
        }
    }

    public static void medical_records() {
        System.out.printf("""
            ==================================================
                [1] Add Medical Record
                [2] View Medical Record
                [3] Edit Medical Record
                [4] Delete Medical Record
                [0] Back
            ==================================================
            Enter choice: """);

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> medical_service.add_medical();
            case 2 -> medical_service.view_medical();
            case 3 -> medical_service.edit_medical();
            case 4 -> medical_service.delete_medical();
            case 0 -> System.out.println("Returning to menu...");
            default -> System.out.println("Invalid choice, try again.");
        }
    }

    public static void billing_payments() {
        System.out.printf("""
            ==================================================
                    VitalClinic System
                [1] Add Billing records
                [2] View Billing records
                [3] Edit Billing records
                [4] Delete Billing records
                [0] Back
            ==================================================
            Enter choice: """);

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> billing_service.add_billing();
            case 2 -> billing_service.view_billing();
            case 3 -> billing_service.edit_billing();
            case 4 -> billing_service.delete_billing();
            case 0 -> System.out.println("Returning to menu...");
            default -> System.out.println("Invalid choice, try again.");
        }
    }

    public static void choices(String doctorID) {
        System.out.printf("""
            ==================================================
                    VitalClinic System
                [1] Patient Records
                [2] Doctor Management
                [3] Appointments
                [4] Medical Records
                [5] Billing and Payments
                [0] Back
            ==================================================
            Enter choice: """);

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> patient_records();
            case 2 -> doctor_management();
            case 3 -> appointments(doctorID);
            case 4 -> medical_records();
            case 5 -> billing_payments();
            case 0 -> System.out.println("Thank you for using the system!");
            default -> System.out.println("Invalid choice, try again.");
        }
    }
}
