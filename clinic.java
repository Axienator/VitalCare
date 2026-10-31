import java.util.*;
import models.login;

public class clinic {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
       
        System.out.printf("""
            ==================================================
                    VitalClinic System%n
                [1] Log in as Admin
                [2] Log in as Staff
                [3] Log in as Member
                [0] Exit%n
            ==================================================
        %n: """);

        if (sc.hasNextInt()) {
            choice = sc.nextInt();
            sc.nextLine();
        } else {
            System.out.println("Invalid input. Please enter a number.");
            sc.close();
            return;
        }

        switch (choice) {
            case 1 -> {
                login.admin_login_menu();
            }
            case 2 -> {
                login.staff_login_menu(args, sc);
            }
            case 3 -> {
                login.member_login_menu();
            }
            case 0 -> {
                System.out.println("Thank you for using the system!");
            }
            default -> {
                System.out.println("Invalid Choice, try again");
            }
        }

        sc.close();
    }
}
