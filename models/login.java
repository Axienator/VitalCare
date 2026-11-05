package models;

import java.io.*;
import java.util.*;
import permissions.perms;
import roles.member;
import roles.staff;

public class login {

    // Admin Login Menu

public static void admin_login_menu(Scanner sc) {

    while (true) {
        ArrayList<String> credential = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new FileReader("admin_credentials.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                credential.add(line);
            }

        } catch (IOException e) {
            System.out.println("Unable to read admin credentials: " + e.getMessage());
            return;
        }

        System.out.println("\n===== VitalCare System - Admin Login =====");

        System.out.print("Username: ");
        if (!sc.hasNextLine()) {
            return;
        }
        String user = sc.nextLine().trim();

        System.out.print("Password: ");
        if (!sc.hasNextLine()) {
            return;
        }
        String password = sc.nextLine();

        boolean loginSuccessful = false;

        for (String line : credential) {
            String[] cred = line.split(",", -1);

            if (cred.length >= 2
                    && cred[0].trim().equalsIgnoreCase(user)
                    && cred[1].trim().equals(password)) {

                loginSuccessful = true;
                break;
            }
        }

        if (loginSuccessful) {
            System.out.println("\nLogin Successful!");
            System.out.println("Welcome " + user + "!");

            perms.choices("");
            return;
        }

        System.out.println("\nLogin Failed! Wrong username or password.");
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
                            VitalCare System - Staff%n
                    ==================================================%n
                    Username:\s""");
            if (!sc.hasNextLine()) {
                return;
            }
            String user = sc.nextLine().trim();

            System.out.print("Password: ");
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
                        && cred[1].trim().equals(password)
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

    public static void member_login_menu(Scanner sc) {

        while (true) {
            ArrayList<String> credential = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(
                    new FileReader("member_credentials.txt"))) {

                String line;

                while ((line = br.readLine()) != null) {
                    credential.add(line);
                }

            } catch (IOException e) {
                System.out.println("Unable to read member credentials: " + e.getMessage());
                return;
            }

            System.out.println("\n===== VitalCare System - Member Login =====");

            System.out.print("Username: ");
            if (!sc.hasNextLine()) {
                return;
            }
            String user = sc.nextLine().trim();

            System.out.print("Password: ");
            if (!sc.hasNextLine()) {
                return;
            }
            String password = sc.nextLine();

            String memberID = null;

            for (String line : credential) {
                String[] cred = line.split(",", -1);

                if (cred.length >= 3
                        && cred[0].trim().equalsIgnoreCase(user)
                        && cred[1].trim().equals(password)) {

                    memberID = cred[2].trim();
                    break;
                }
            }

            if (memberID != null && !memberID.isEmpty()) {
                System.out.println("\nLogin Successful!");
                System.out.println("Welcome Member " + user + "!");
                System.out.println("Member ID: " + memberID);

                member.main(new String[]{}, memberID);
                return;
            }

            System.out.println("\nLogin Failed!");
            System.out.println("Wrong password or username.");
        }
    }


    // Checks if a value is already in a column of a file (0 = first column)
    private static boolean value_exists(String file, int column, String value) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", -1);

                if (data.length > column && data[column].trim().equalsIgnoreCase(value)) {
                    return true;
                }
            }
        } catch (IOException e) {
            // File does not exist yet, so nothing is registered
        }

        return false;
    }

    // Adds one line to a credentials file
    private static void add_credential(String file, String record) {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.isBlank()) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            // File does not exist yet, it will be created
        }

        lines.add(record);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }

            System.out.println("Registered successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Asks for the admin login, returns true if it is correct
    private static boolean admin_verify(Scanner sc) {
        System.out.println("Admin login is required. Leave the username empty to cancel.");

        while (true) {
            System.out.print("Admin Username: ");
            if (!sc.hasNextLine()) {
                return false;
            }
            String user = sc.nextLine().trim();

            if (user.isEmpty()) {
                return false;
            }

            System.out.print("Admin Password: ");
            if (!sc.hasNextLine()) {
                return false;
            }
            String password = sc.nextLine();

            try (BufferedReader br = new BufferedReader(new FileReader("admin_credentials.txt"))) {
                String line;

                while ((line = br.readLine()) != null) {
                    String[] cred = line.split(",", -1);

                    if (cred.length >= 2
                            && cred[0].trim().equalsIgnoreCase(user)
                            && cred[1].trim().equals(password)) {
                        return true;
                    }
                }
            } catch (IOException e) {
                System.out.println("Unable to read admin credentials: " + e.getMessage());
                return false;
            }

            System.out.println("Login failed. Wrong username or password.");
        }
    }

    // Member Register
    public static void member_register(Scanner sc) {
        System.out.print("Username: ");
        String user = sc.nextLine().trim();

        System.out.print("Password: ");
        String password = sc.nextLine().trim();

        System.out.print("Member ID (your Patient ID): ");
        String memberID = sc.nextLine().trim();

        if (user.isEmpty() || password.isEmpty() || memberID.isEmpty()) {
            System.out.println("All fields are required.");
            return;
        }

        if (user.contains(",") || password.contains(",") || memberID.contains(",")) {
            System.out.println("Commas are not allowed.");
            return;
        }

        if (value_exists("member_credentials.txt", 0, user)) {
            System.out.println("Username is already taken.");
            return;
        }

        if (!value_exists("patient.txt", 0, memberID)) {
            System.out.println("Patient ID not found. Ask the clinic to create your patient record first.");
            return;
        }

        if (value_exists("member_credentials.txt", 2, memberID)) {
            System.out.println("This Patient ID already has an account.");
            return;
        }

        add_credential("member_credentials.txt", user + "," + password + "," + memberID);
    }

    // Staff Register (admin must log in first)
    public static void staff_register(Scanner sc) {
        if (!admin_verify(sc)) {
            System.out.println("Registration cancelled.");
            return;
        }

        System.out.println("Admin verified.");

        System.out.print("Staff Username: ");
        String user = sc.nextLine().trim();

        System.out.print("Staff Password: ");
        String password = sc.nextLine().trim();

        System.out.print("Staff ID: ");
        String staffID = sc.nextLine().trim();

        if (user.isEmpty() || password.isEmpty() || staffID.isEmpty()) {
            System.out.println("All fields are required.");
            return;
        }

        if (user.contains(",") || password.contains(",") || staffID.contains(",")) {
            System.out.println("Commas are not allowed.");
            return;
        }

        if (value_exists("staff_credentials.txt", 0, user)) {
            System.out.println("Username is already taken.");
            return;
        }

        if (value_exists("staff_credentials.txt", 2, staffID)) {
            System.out.println("Staff ID is already used.");
            return;
        }

        add_credential("staff_credentials.txt", user + "," + password + "," + staffID);
    }
}
