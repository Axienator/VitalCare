package models;
import java.util.*;

public class login {
    public static void login_menu () 
    {
        Scanner sc = new Scanner(System.in);
        System.out.printf("""
        ==================================================
                        VitalClinic System%n          
            Username:%n
            Password:%n
        ================================================== %n%nUsername: 
        """);

        String user = sc.nextLine();

        System.out.printf("""
          %n==================================================
                        VitalClinic System%n   
            Username: %s%n
            Password:%n
        ================================================== %n%nPassword
        """, user);

        String password = sc.nextLine();

        System.out.printf("""
          %n==================================================
                        VitalClinic System 

                        Login Successful!%n
                        Welcome %s
                
        ==================================================
        """, user, password);

        
    }
}
