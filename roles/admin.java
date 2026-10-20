// Admin options

package roles;
import permissions.perms;
import permissions.perms.*;
import java.util.*;

public class admin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.printf("""
            ==================================================
                    VitalClinic System%n
                [1] Patient records
                [2] Doctor Management
                [3] Appointments
                [4] Medical Records
                [5] Billing and Payments
                [0] Exit%n
            ==================================================
        %n: """);

        choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Patient records");
                break;
            case 2:
                perms.doctor_management();
                break;
            case 3:
                System.out.println("Appointments");
                break;
            case 4:
                System.out.println("Medical Records");
                break;
            case 5:
                System.out.println("Billing and Payments");
                break;
            case 0:
                System.out.println("Thank you for using the system!");
                break;
            default:
                System.out.println("Invalid Choice, try again");
        }
    }
}
