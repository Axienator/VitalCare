
package roles;

import java.util.Scanner;
import permissions.perms;

public class staff {

    public static void main(String[] args, String staffID, Scanner sc) {
        boolean running = true;

        while (running) {
            System.out.printf("""
                ==================================================
                        VitalCare System - Staff Menu%n
                    [1] Patient records
                    [2] Appointments
                    [3] Medical Records
                    [0] Exit%n
                ==================================================
                
                Enter choice: """);

            if (!sc.hasNextLine()) {
                return;
            }

            String input = sc.nextLine().trim();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> perms.patient_records();
                case 2 -> perms.appointments(staffID);
                case 3 -> perms.medical_records();
                case 0 -> {
                    System.out.println("Thank you for using the system!");
                    running = false;
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }
}
