package models;

import java.io.*;
import java.util.*;
import permissions.perms;
public class login {
    public static void admin_login_menu () 
    {
        ArrayList<String> credential = new ArrayList<>();
        
        while(true){
            try (BufferedReader br = new BufferedReader(new FileReader("credentials.txt"))) {
            Scanner sc = new Scanner(System.in);

            System.out.printf("""
            ==================================================
                            VitalClinic System%n          
                Username:%n
                Password:%n
            ================================================== %n%nUsername: 
            """);

            String line = br.readLine();

            while (line != null) {
                credential.add(line);
                line = br.readLine();
            }

            String user = sc.nextLine();
            
            System.out.printf("""
            %n==================================================
                            VitalClinic System%n   
                Username: %s%n
                Password:%n
            ================================================== %n%nPassword
            """, user);

            String password = sc.nextLine();

            for(int i = 0; i < credential.size(); i++){
                String[] cred = credential.get(i).split(",", -1);

                if(cred[0].trim().equalsIgnoreCase(user) && cred[1].trim().equalsIgnoreCase(password)){
                    System.out.printf("""
                                %n==================================================
                                                VitalClinic System 

                                                Login Successful%n
                                                Welcome %s!
                                        
                                ==================================================%n%n%n%n%n
                                """, user, password);
                    perms.choices();
                    break;
                }else{
                     System.out.printf("""
                                %n==================================================
                                                VitalClinic System 

                                                Login Failed!%n
                                         Wrong password or Username
                                        
                                ==================================================%n%n%n%n%n
                                """, user, password);
                }
            }


        } catch (Exception e) {
            System.out.println(
                "An error occured: " + e.getMessage()
            );
        }
        }
    }
}

