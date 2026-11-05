import java.util.Scanner;
import models.login;

public class clinic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
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
                    [1] Log in as Admin
                    [2] Log in as Staff
                    [3] Log in as Member
                    [4] Register as Member
                    [5] Register Staff (Admin only)
                    [0] Exit
                ==================================================
                Enter choice: """);

            if (!sc.hasNextLine()) {
                break;
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
                case 1 -> login.admin_login_menu(sc);
                case 2 -> login.staff_login_menu(args, sc);
                case 3 -> login.member_login_menu(sc);
                case 4 -> login.member_register(sc);
                case 5 -> login.staff_register(sc);

                case 0 -> {
                    System.out.println("\nThank you for using VitalCare System!");
                    return;
                }

                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }
}
