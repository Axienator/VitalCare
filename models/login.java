package models;

import java.io.*;
import java.util.*;
import permissions.perms;
import roles.member;
import roles.staff;

public class login {
    
    // Admin Login Menu
    public static void admin_login_menu () 
    {
        try (Scanner sc = new Scanner(System.in)) {
        while(true){
            // Fresh list each attempt so credentials are not duplicated
            ArrayList<String> credential = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader("admin.txt"))) {

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
            ================================================== %n%nPassword: 
            """, user);

            String password = sc.nextLine();
            boolean loginSuccessful = false;

            for(int i = 0; i < credential.size(); i++){
                String[] cred = credential.get(i).split(",", -1);

                if(cred.length >= 2 && cred[0].trim().equalsIgnoreCase(user) && cred[1].trim().equals(password)){
                    System.out.printf("""
                                %n==================================================
                                                VitalClinic System 

                                                Login Successful%n
                                                Welcome %s!
                                        
                                ==================================================%n%n%n%n%n
                                """, user);
                    loginSuccessful = true;
                    perms.choices("");
                    break;
                }
            }

            if (loginSuccessful) {
                break;
            } else {
                System.out.printf("""
                            %n==================================================
                                            VitalClinic System 

                                            Login Failed!%n
                                     Wrong password or Username
                                    
                            ==================================================%n%n%n%n%n
                            """);
            }
        } catch (Exception e) {
            System.out.println(
                "An error occurred: " + e.getMessage()
            );
            break;
        }
        }
        }
    }

    // Staff Login Menu
    public static void staff_login_menu(String[] args, Scanner sc) {
        List<String> credentials = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("staff_credentials.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isBlank()) {
                    credentials.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to read staff credentials: " + e.getMessage());
            return;
        }

        while (true) {
            System.out.printf("""
                    ==================================================
                            VitalClinic System - Staff%n
                    ==================================================%n
                    Username: """);
            if (!sc.hasNextLine()) {
                return;
            }
            String user = sc.nextLine().trim();

            System.out.print("Password:");
            if (!sc.hasNextLine()) {
                return;
            }
            String password = sc.nextLine();

            String staffID = null;
            for (String line : credentials) {
                String[] cred = line.split(",", 3);
                if (!user.isBlank()
                        && !password.isEmpty()
                        && cred.length == 3
                        && cred[0].trim().equalsIgnoreCase(user)
                        && cred[1].equals(password)
                        && !cred[2].isBlank()) {
                    staffID = cred[2].trim();
                    break;
                }
            }

            if (staffID != null) {
                System.out.printf("%nLogin successful. Welcome, %s!%n%n", user);
                staff.main(args, staffID, sc);
                return;
            }

            System.out.println("Login failed. Wrong username or password.");
        }
    }

    // Member Login Menu
    public static void member_login_menu() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                ArrayList<String> credential = new ArrayList<>();

                try (BufferedReader br = new BufferedReader(
                        new FileReader("member_credentials.txt"))) {

                    System.out.print("Username: ");
                    String user = sc.nextLine();

                    System.out.print("Password: ");
                    String password = sc.nextLine();

                    String line = br.readLine();

                    while (line != null) {
                        credential.add(line);
                        line = br.readLine();
                    }

                    boolean loginSuccessful = false;

                    for (int i = 0; i < credential.size(); i++) {
                        String[] cred = credential.get(i).split(",", -1);

                        if (cred.length >= 3
                                && cred[0].trim().equalsIgnoreCase(user)
                                && cred[1].trim().equals(password)) {

                            String memberID = cred[2].trim();

                            System.out.println("\nLogin Successful!");
                            System.out.println("Welcome Member " + user + "!");

                            System.out.println("Member ID: " + memberID);

                            loginSuccessful = true;
                            member.main(new String[]{}, memberID);
                            break;
                        }
                    }

                    if (loginSuccessful) {
                        break;
                    } else {
                        System.out.println("\nLogin Failed!");
                        System.out.println("Wrong password or username.");
                    }

                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                    break;
                }
            }
        }
    }
}
