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

        choice = sc.nextInt();

        switch (choice) {
            case 1:
                login.login_menu();
                break;
            case 2:
                System.out.println("Staff");
                break;
            case 3:
                System.out.println("Member");
                break;
            case 0:
                System.out.println("Thank you for using the system!");
            default:
                System.out.println("Invalid Choice, try again");
        }


        
        sc.close();

    }

    
}

// Patient Information
// Patient ID
// First name and last name
// Patient Age
// Sex
// Contact number
// Address
// Emergency contact (Optional)
// Date Regsitered