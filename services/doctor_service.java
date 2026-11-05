package services;
import java.io.*;
import java.util.*;

public class doctor_service {

    static Scanner sc = new Scanner(System.in);

    // Reads every line of doctors.txt; returns null (after printing the error) if it can't be read
    private static ArrayList<String> read_doctors() {
        ArrayList<String> doctors = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("doctors.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                doctors.add(line);
            }

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            return null;
        }

        return doctors;
    }

    // Overwrites doctors.txt with the given lines
    private static boolean write_doctors(ArrayList<String> doctors) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("doctors.txt"))) {

            for (String doctor : doctors) {
                bw.write(doctor);
                bw.newLine();
            }
            return true;

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }

    public static void delete_doctor() {
        System.out.print("Enter Doctor ID: ");
        String search_id = sc.nextLine().trim();

        ArrayList<String> doctors = read_doctors();
        if (doctors == null) {
            return;
        }

        boolean found = false;

        for (int i = 0; i < doctors.size(); i++) {
            String[] doctor = doctors.get(i).split(",", -1);

            if (doctor[0].trim().equalsIgnoreCase(search_id)) {
                doctors.remove(i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No doctor found with ID: " + search_id);
            return;
        }

        if (write_doctors(doctors)) {
            System.out.println("Doctor deleted successfully!");
        }
    }

    public static void edit_doctor() {
        System.out.print("Enter Doctor ID: ");
        String search_id = sc.nextLine().trim();

        // The file is read fully first and only rewritten once the edit is complete,
        // so a mistake or an error can never wipe out doctors.txt.
        ArrayList<String> doctors = read_doctors();
        if (doctors == null) {
            return;
        }

        boolean found = false;

        for (int i = 0; i < doctors.size(); i++) {
            // This will take the doctor's record from the Arraylist and split into an array
            String[] doctor = doctors.get(i).split(",", -1);

            if (doctor.length >= 4 && doctor[0].trim().equalsIgnoreCase(search_id)) {
                found = true;

                System.out.print("Enter new Doctor Name: ");
                String name = sc.nextLine().trim();
                System.out.print("Enter new Doctor Schedule: ");
                String schedule = sc.nextLine().trim();
                System.out.print("Enter new Doctor Phone Number: ");
                String phone = sc.nextLine().trim();

                if (name.isEmpty() || schedule.isEmpty() || phone.isEmpty()) {
                    System.out.println("All fields are required. Edit cancelled.");
                    return;
                }

                doctors.set(i, doctor[0].trim() + ", " + name + ", " + schedule + ", " + phone);
                break;
            }
        }

        if (!found) {
            System.out.println("No doctor found with ID: " + search_id);
            return;
        }

        if (write_doctors(doctors)) {
            System.out.println("Doctor updated successfully!");
        }
    }

    public static void view_doctor() {

        System.out.print("Enter Doctor ID: ");
        String search_id = sc.nextLine().trim();

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader("doctors.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] doctor = line.split(",", -1);
                // This will split the line into an array (-1 is used to preserve all the elements even if one of the element is empty.)
                if (doctor.length >= 4 && doctor[0].trim().equalsIgnoreCase(search_id)) {
                    System.out.println("Doctor ID: " + doctor[0].trim());
                    System.out.println("Doctor Name: " + doctor[1].trim());
                    System.out.println("Doctor Schedule: " + doctor[2].trim());
                    System.out.println("Doctor Phone Number: " + doctor[3].trim());
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("No doctor found with ID: " + search_id);
            }

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        // Note: the shared Scanner is intentionally NOT closed here; closing it
        // would also close System.in and break every later menu.
    }

    public static void create_doctor() {

        System.out.print("Doctor ID: ");
        String doctorID = sc.nextLine().trim();

        boolean exists = false;

        try (BufferedReader br = new BufferedReader(
                new FileReader("doctors.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] doctor = line.split(",", -1);

                if (doctor.length >= 1
                        && doctor[0].trim().equalsIgnoreCase(doctorID)) {
                    exists = true;
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading doctors file: " + e.getMessage());
            return;
        }

        if (exists) {
            System.out.println("Doctor ID already exists.");
            return;
        }

        System.out.print("Doctor Name: ");
        String name = sc.nextLine().trim();

        // doctors.txt stores ID, name, schedule, phone (matches edit/view)
        System.out.print("Doctor Schedule: ");
        String schedule = sc.nextLine().trim();

        System.out.print("Phone: ");
        String phone = sc.nextLine().trim();

        if (doctorID.isEmpty() || name.isEmpty()
                || schedule.isEmpty() || phone.isEmpty()) {
            System.out.println("All fields are required.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("doctors.txt", true))) {

            bw.write(doctorID + ", " + name + ", "
                    + schedule + ", " + phone);
            bw.newLine();

            System.out.println("Doctor added successfully!");

        } catch (IOException e) {
            System.out.println("Error saving doctor: " + e.getMessage());
        }
    }
}
