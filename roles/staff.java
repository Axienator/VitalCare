package roles;

import java.util.*;
import permissions.perms;

public class staff {

    public static void main(String[] args, String doctorID) {
        try (Scanner sc = new Scanner(System.in)) {
            main(args, doctorID, sc);
        }
    }

    public static void main(String[] args, String staffID, Scanner sc) {
        boolean running = true;

        while (running) {
            System.out.printf("""
                ==================================================
                        VitalClinic System - Staff Menu%n
                    [1] Patient records
                    [2] Doctor Management
                    [3] Appointments
                    [4] Medical Records
                    [5] Billing and Payments
                    [0] Exit%n
                ==================================================
                %n: """);

            int choice = -1;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); // Consume newline
            } else {
                sc.nextLine(); // Clear invalid input
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> perms.patient_records();
                case 2 -> perms.doctor_management();
                case 3 -> perms.appointments(staffID);
                case 4 -> perms.medical_records();
                case 5 -> System.out.println("Billing and Payments is not available.");
                case 0 -> {
                    System.out.println("Thank you for using the system!");
                    running = false;
                }
                default -> System.out.println("Invalid Choice, try again");
            }
        }
    }
}
