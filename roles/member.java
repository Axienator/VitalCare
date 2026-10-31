package roles;

import java.util.*;
import services.appointment_service;
import services.billing_service;
import services.patient_service;
public class member {

    public static void main(String[] args, String memberID) {
        int choice;
        
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.printf("""
                    ==================================================
                            VitalClinic System - Member Menu%n
                        [1] Patient Records
                        [2] Appointments
                        [3] Billing and Payments
                        [0] Exit%n
                    ==================================================
                %nEnter choice: """);

                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    sc.nextLine(); // Consume newline
                } else {
                    sc.nextLine(); // Clear invalid input
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }

                switch (choice) {
                    case 1 -> {
                        System.out.println("=== Patient Records ===");
                        patient_service.view_patient();
                    }
                    case 2 -> {
                        System.out.println("=== Appointments ===");
                        appointment_service.view_appointment("");
                    }
                    case 3 -> {
                        System.out.println("=== Billing and Payments ===");
                        billing_service.view_billing(memberID);
                    }
                    case 0 -> {
                        System.out.println("Thank you for using the system!");
                        return;
                    }
                    default -> {
                        System.out.println("Invalid Choice, try again");
                    }
                }
            }
        }
    }
}
