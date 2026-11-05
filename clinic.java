import java.util.Scanner;
import models.login;

public class clinic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.printf("""
            
            ============================================================
            
                            +------------------+
                            |        +         |
                            |     + + + +      |
                            |        +         |
                            +------------------+
            
                        V I T A L C A R E
            
                            HEALTHCARE SYSTEM
            
                    "Caring for Life, Every Step."
            
            ============================================================
            
            Press Enter to continue...
            """);

        sc.nextLine();

        while (true) {
            System.out.printf("""
                
                ==================================================
                            VITALCARE SYSTEM
                ==================================================
                    [1] Log in as Admin
                    [2] Log in as Staff
                    [3] Log in as Member
                    [4] Register as Member
                    [5] Register Staff (Admin only)
                    [0] Exit
                ==================================================
                Enter choice: """);

            if (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> login.admin_login_menu();
                case 2 -> login.staff_login_menu(args, sc);
                case 3 -> login.member_login_menu();
                case 4 -> login.member_register(sc);
                case 5 -> login.staff_register(sc);

                case 0 -> {
                    System.out.println("\nThank you for using VitalCare System!");
                    sc.close();
                    return;
                }

                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }
}
