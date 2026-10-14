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
            =================================================
        """);

        String user = sc.nextLine();

        System.out.printf("""
            ==================================================
                        VitalClinic System%n   
                Username: %s%n
                Password:%n
            =================================================
                """, user);
        String password = sc.nextLine();

        System.out.printf("""
            ==================================================
                        VitalClinic System%n   
                Username: %s%n
                Password: %s%n
            =================================================
                """, user, password);

        sc.close();
    }
}
